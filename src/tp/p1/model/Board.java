package tp.p1.model;

import tp.p1.model.gameElements.AlienShip;
import tp.p1.model.gameElements.ExplosiveShip;
import tp.p1.model.gameElements.GameElements;

public class Board {
	
	private GameElements[] elements;
	private int currentElements;	
	
	public Board (int width, int height) {
		elements = new GameElements[width*height];		
	}
	
	private int getcurrentElements () {
		return currentElements;
	}
	
	public void add (GameElements gameElement) {
		if (currentElements < elements.length) {
			elements[currentElements] = gameElement;
			currentElements++;
		}
	}
	
	public void update() {
		AlienShip.resetNumOfShipsMovedInTurn();		// for lateral movement of alienships
		// 1. Move object
		// 2. Call checkAttack for that object
		for (int i = 0; i < currentElements; i++) {
			elements[i].move();
			if (elements[i].isAlive()) {		
				// To avoid destroyed weapons (shield = 0 but still not removed from array) from attacking 
				checkAttacks(elements[i]);
			}			
		}			
		removeDead();
		removeDead();  // For explosive ship dead killing other ships on previous removeDead()
		removeOutOfBoard();
	}
	
	public void checkAttacks(GameElements gameElement) {
		boolean hasAttacked = false;
		// For the given gameElem, try to attack each other element
		
		for (int i = 0; i < currentElements; i++) {					// condition of X,Y checked inside
			if (gameElement.performAttack(elements[i])) {
				hasAttacked = true;
			}
		}
		if (hasAttacked) {
			gameElement.setShield(gameElement.getShield()-1);
		}
		
	}
	
	public boolean performExplosiveShipAttack(int posX, int posY) {
		// find object (if possible)
		// If found, call receiveExpl.. on that object
		boolean attacked = false;
		GameElements elem = getObjectAt(posX, posY);
		if (elem != null) {
			attacked = elem.receiveExplosiveShipAttack(ExplosiveShip.DAMAGE);
		}
		return attacked;
	}
	
	public void computerAction() {
		for (int i = 0; i < currentElements; i++) {
			elements[i].computerAction();
		}		
	}
	
	public String posToString( int x, int y ) {
		String str = "";
		for (int i = 0; i < currentElements; i++) {
			str += elements[i].checkPos(x, y);
		}
		return str;
	}
	
	private GameElements getObjectAt ( int x, int y ) {
		GameElements aux = null;		
		int idx = this.getIndex(x, y);
		if (idx != -1) {
			aux = elements[idx];
		}
		return aux;
	}
	
	private int getIndex( int x, int y ) {
		int idx = -1;
		boolean found = false;
		int i = 0;
		while (i < elements.length && !found) {
			if ((elements[i] != null) && (elements[i].isOnPosition(x, y))) {
				idx = i;
				found = true;
			}
			i++;
		}
		return idx;
	}
	
	public void remove (GameElements gameElement) {
		// 1. Find pos in list
		int idx = getIndex(gameElement.getPosX(), gameElement.getPosY());
		
		// 2. Shift left remaining elements
		if (idx != -1) {
			this.elements[idx].onDelete();		// Perform actions before dying 
			
			for (int i = idx; i < getcurrentElements() - 1; i++) {
				this.elements[i] = this.elements[i + 1];
			}	
			
			this.elements[this.getcurrentElements() - 1] = null; 	// Second call to getcurrentElements returns one less 		
			//Delete last element pointer because it is already pointed by the previous one 
			currentElements--;
		}
	}
	
	private void remove (int idx) {		
		// Shift left remaining elements
		if (idx != -1) {
			this.elements[idx].onDelete();		// Perform actions before dying 
			
			for (int i = idx; i < getcurrentElements() - 1; i++) {
				this.elements[i] = this.elements[i + 1];
			}	
			
			this.elements[this.getcurrentElements() - 1] = null; 	// Second call to getcurrentElements returns one less  		
			//Delete last element pointer because it is already pointed by the previous one 
			currentElements--;
		}
	}
	
	private void removeDead() {
		int i = 0;
		while(i < this.getcurrentElements()) {
			if(!elements[i].isAlive()) {
				remove(i);		// Call to Remove() shifts list to left, so the same i position
											// must be checked again because it contains the next object
			}
			else {
				i++; 	//We have to check if the new position shifted has a ship alive or not
			}			//if it is really alive, we check the next ones
		}
	}
	
	private void removeOutOfBoard() {
		int i = 0;
		while(i < this.getcurrentElements()) {
			if(elements[i].isOut()) {
				remove(i);		// Call to Remove() shifts list to left, so the same i position
											// must be checked again because it contains the next object
			}
			else {
				i++; 	
			}			
		}
	}

	public String stringify() {
		String result = "";
		for (int i = 0; i < currentElements; i++) {
			result += elements[i].stringify() + "\n";
		}
		return result;
	}
}

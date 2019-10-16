package tp.p1;

public class BombList {
	
	private Bomb [] bombList;

	public BombList(Level diffLevel) {
		// at most one projectile from each destroyer at a given time
		// then the max size of list is the starting number of destroyers
		this.bombList = new Bomb[diffLevel.getNumOfDestroyers()];	
		// ucmMissile will be created/set-to-null at run time
	}
	
	public void newBomb(int posX, int posY, Destroyer destroyer) {
		this.bombList[getNumOfValidBombs()] = new Bomb(posX, posY, destroyer);
		// The constructor sets the canShoot of destroyer to false
	}
	
	public void deleteBomb(int posX, int posY) {
		boolean listShifted = false;
		// 1. Find pos in list
		int idx = findBomb(posX, posY);
		
		// 2. Shift left remaining elements
		for (int i = idx; i < getNumOfValidBombs() - 1; i++) {
			listShifted = true;
			this.bombList[i] = this.bombList[i + 1];
			
		}	
		
		this.bombList[getNumOfValidBombs() - 1] = null; 	// Segunda llamada a getvalidbomb retorna una menos 		
			//Delete last element pointer because it is already pointed by the previous one 
		
		
		
	}

	
	public int getNumOfValidBombs() {
		// Return num of instantiated bombs in projectileList (i.e. num of not null elems)
		int count = 0;
		for (Bomb current : this.bombList) {
			if (current != null) {
				count++;
			}
		}
		return count;
	}
	
	public String checkPos (int x, int y) {
		String str = "";
		int i = 0;
		boolean found = false;
		while ( i < getNumOfValidBombs() && !found) {
			if (bombList[i].getPosX() == x && bombList[i].getPosY() == y) {
				str = bombList[i].toString();
				found = true;
			}
			i++;
		}
		return str;
	}
	
	private int findBomb(int posX, int posY) {
		int idx = 0;
		boolean found = false;
		while (!found && idx < getNumOfValidBombs()) {
			if (this.bombList[idx].getPosX() == posX && this.bombList[idx].getPosY() == posY) {
				found = true;
			} else {
				idx++;
			}
		}	
		if (!found) {
			idx = -1;
		}
		return idx;
	}
	
	public void incrementPosY(int idx) {
		this.bombList[idx].incrementPosY();
	}
	
	public boolean bombOutOfBoard(int idx) {
		return this.bombList[idx].outOfBoard();
	}
	
	public int getPosX(int idx) {
		return this.bombList[idx].getPosX();
	}
	
	public int getPosY(int idx) {
		return this.bombList[idx].getPosY();
	}
	
}

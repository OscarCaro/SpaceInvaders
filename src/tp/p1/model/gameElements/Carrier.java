package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Carrier extends AlienShip{
	
	public Carrier(int posX, int posY, Game game) {	
		super(posX, posY, game, 2, 5);
		AlienShip.incrementCounter();
	}
	
	@Override
	public String toString() {
		return "-<" + this.getShield() + ">-";
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		AlienShip.decrementCounter();
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		// Idea: have a static method direction, and move the carrier to that direction
		// Change this attribute direction when a carrier is on one of the sides
		
	}
}

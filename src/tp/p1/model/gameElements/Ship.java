package tp.p1.model.gameElements;

import tp.p1.model.Game;

public abstract class Ship extends GameElements {
	private int shield;
	
	public Ship(int posX,int posY,Game game, int shield) {
		super(posX, posY, game);
		this.shield = shield;
	}
	
	public int getShield() {
		return shield;
	}
	
	public void setShield(int shield) {
		this.shield = shield;
	}
	
	public void decrementShield(int amount) {
		this.shield -= amount;
	}
}

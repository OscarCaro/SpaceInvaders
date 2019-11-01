package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Carrier extends AlienShip implements Printable{
	
//	private int posX, posY;		
//	private int shield;		
//	private final int points;
	
	public Carrier(int posX, int posY, Game game) {	
		super(posX, posY, game, 2, 5);
	}
	
//	public void decrementShield() {
//		this.shield--;
//	}
	
	public String toString() {
		return "-<" + this.getShield() + ">-";
	}
	
//	public void setPosX(int posX) {
//		this.posX = posX;
//	}
//	
//	public int getPosX() {
//		return posX;
//	}
//
//	public void setPosY(int posY) {
//		this.posY = posY;
//	}
//
//	public int getPosY() {
//		return posY;
//	}
//
//	public int getShield() {
//		return shield;
//	}		
//
//	public int getPoints() {
//		return points;
//	}	
}

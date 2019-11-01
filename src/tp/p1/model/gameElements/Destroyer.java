package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Destroyer extends AlienShip implements Printable{
	
//	private int posX, posY;
//	private int shield;
	private boolean canShoot;
//	private final int points = 10;		
	
	public Destroyer (int posX, int posY, Game game) {
		super(posX, posY, game, 1, 10);
		this.canShoot = true;
	}	
	
	public String toString() {
		return "!<" + this.getShield() + ">!";
	}
	
//	public void decrementShield() {
//		this.shield--;
//	}
//	
//	public int getShield() {
//		return shield;
//	}
	
	public boolean isCanShoot() {
		return canShoot;
	}

	public void setCanShoot(boolean canShoot) {
		this.canShoot = canShoot;
	}

//	public void setPosX(int posX) {
//		this.posX = posX;
//	}
//
//	public void setPosY(int posY) {
//		this.posY = posY;
//	}
//
//	public int getPosX() {
//		return posX;
//	}
//
//	public int getPosY() {
//		return posY;
//	}
//
//	public int getPoints() {
//		return points;
//	}	
}

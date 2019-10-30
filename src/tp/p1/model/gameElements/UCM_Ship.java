package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class UCM_Ship extends Ship {

	//private int posX, posY;
//	private int shield;
	
	private String sprite = "/-^-\\";
	private boolean shock; 	
	private boolean canShoot;

	
	public UCM_Ship (Game game) {
		super(4, 7, game, 3);
		this.shock = false;
		this.canShoot = true;
	}
	
	public boolean isCanShoot() {
		return canShoot;
	}

	public void setCanShoot(boolean canShoot) {
		this.canShoot = canShoot;
	}
	
	public boolean isShock() {
		return shock;
	}
	
	public void setShock(boolean shock) {
		this.shock = shock;
	}

//	public int getShield() {
//		return shield;
//	}
//	
//	public void decrementShield() {
//		this.shield--;
//	}

//	public int getPosX() {
//		return posX;
//	}
//
//	public void setPosX(int posX) {
//		this.posX = posX;
//	}
//
//	public int getPosY() {
//		return posY;
//	}
//
//	public void setPosY(int posY) {
//		this.posY = posY;
//	}
	
	public String toString() {
		return this.sprite;
	}

	public String checkPos (int x, int y) {
		String str = "";
		if (this.getPosX() == x && this.getPosY() == y) {
			str = this.toString();
		}
		return str;
	}	
	
}

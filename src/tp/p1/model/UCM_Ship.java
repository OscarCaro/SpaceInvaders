package tp.p1.model;

public class UCM_Ship {

	private int posX, posY;
	private int shield;
	
	private String sprite = "/-^-\\";
	private boolean shock; 	
	private boolean canShoot;

	
	public UCM_Ship () {
		this.shield = 3;
		this.posX = 4;
		this.posY = 7;
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

	public int getShield() {
		return shield;
	}
	
	public void decrementShield() {
		this.shield--;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String checkPos (int x, int y) {
		String str = "";
		if (this.posX == x && this.posY == y) {
			str = this.sprite;
		}
		return str;
	}	
	
}

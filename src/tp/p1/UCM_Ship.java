package tp.p1;

public class UCM_Ship {

	private int posX, posY;
	private int shield;
	
	private final int damage = 1;
	private final boolean weapons = true;
	private String sprite = "/-^-\\";
	private boolean shock; 	
	private boolean canShoot;

	
	public UCM_Ship () {
		//Class constructor
		// Initial values:
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
	
	

	public void setShock(boolean shock) {
		this.shock = shock;
	}

	public String checkPos (int x, int y) {
		String str = "";
		if (this.posX == x && this.posY == y) {
			str = this.sprite;
		}
		return str;
	}
	
	
	
//	public String toString() {
//		return this.sprite;
//	}
}

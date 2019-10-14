package tp.p1;

public class Destroyer {
	
	private int posX, posY;		// These attributes change over time -> init in constructor
	private int shield;
	private int id;
	private boolean canShoot;
	
	private final int damage = 1;
	private final boolean weapons = true;
	private final int points = 10;
		
	
	public Destroyer (int posX, int posY, int id) {
		//Class constructor
		this.shield = 1;
		this.posX = posX;
		this.posY = posY;
		this.canShoot = true;
	}
	
	
	public String toString() {
		return "!<" + this.shield + ">!";
	}
	
	
	
	public boolean isCanShoot() {
		return canShoot;
	}


	public void setCanShoot(boolean canShoot) {
		this.canShoot = canShoot;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}

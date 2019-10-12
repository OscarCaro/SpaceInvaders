package tp.p1;

public class UCM_Ship {

	private int posX, posY;
	private int shield;
	
	private final int damage = 1;
	private final boolean weapons = true;
	private String sprite = "/-^-\\";
	private boolean shock; 	
	
	public UCM_Ship () {
		//Class constructor
		// Initial values:
		this.shield = 3;
		this.posX = 4;
		this.posY = 7;
		this.shock = false;
	}
	
	public boolean isShock() {
		return shock;
	}

	public int getShield() {
		return shield;
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
	
	
	
//	public String toString() {
//		return this.sprite;
//	}
}

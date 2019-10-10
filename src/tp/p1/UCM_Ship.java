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

package tp.p1;

public class Destroyer {
	
	private int posX, posY;		// These attributes change over time -> init in constructor
	private int shield;
	
	private final int damage = 1;		// final = const
	private final boolean weapons = true;
	private final int points = 10;
	
	public Destroyer (int posX, int posY) {
		//Class constructor
		this.shield = 1;
		this.posX = posX;
		this.posY = posY;
	}
}

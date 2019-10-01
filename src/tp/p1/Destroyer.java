package tp.p1;

public class Destroyer {
	
	private int posX, posY;		// These attributes change over time -> init in constructor
	private static int shield;
	
	private final int damage = 1;		// final = const
	private final boolean weapons = true;
	private final int points = 10;
	
	private String sprite;
	
	public Destroyer (int posX, int posY) {
		//Class constructor
		this.sprite = "!<" + Destroyer.shield + ">!"; 
		this.shield = 1;
		this.posX = posX;
		this.posY = posY;
	}
}

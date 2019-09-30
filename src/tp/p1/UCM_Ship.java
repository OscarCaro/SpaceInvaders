package tp.p1;

public class UCM_Ship {

	private int posX, posY;		// These attributes change over time -> init in constructor
	private int shield;
	
	private final int damage = 1;		// final = const
	private final boolean weapons = true;
	
	public UCM_Ship (int posX, int posY) {
		//Class constructor
		
		// Initial values:
		this.shield = 3;
		this.posX = posX;
		this.posY = posY;
	}
}

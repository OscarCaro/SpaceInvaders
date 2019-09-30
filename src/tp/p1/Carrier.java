package tp.p1;

public class Carrier {
	// (UFO es objeto de esta clase pero tiene atributos con valor diferente.
	
	private int posX, posY;		// These attributes change over time -> init in constructor
	private int shield;		
	private final int points;

	
	private final int damage = 0;	// final = const
	private final boolean weapons = false;
	
	public Carrier(boolean isUfo ,int posX, int posY) {
		//Class constructor
		if (isUfo) {
			// Ufo constructor
			this.points = 25;
			this.shield = 1;
			this.posX = posX;
			this.posY = posY;			
		} else {
			// Carrier constructor
			this.points = 5;
			this.shield = 2;
			this.posX = posX;
			this.posY = posY;
		}	
	}
}

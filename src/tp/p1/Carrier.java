package tp.p1;

public class Carrier {
	// (UFO es objeto de esta clase pero tiene atributos con valor diferente.
	
	private int posX, posY;		// These attributes change over time -> init in constructor
	private int shield;		//Shield me da error si esto no es static
	private final int points;

	private final int damage = 0;
	private final boolean weapons = false;
	
	private String sprite = "-<" + this.shield + ">-";  		//Lo meto dentro del constructor para que sea mas comodo de usar y distinguir
	private String ufoSprite = "<(+)>";   
	
	
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
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public String toString() {
		return this.sprite;									//sprite normal
	}
	
	public String UfotoString() {
		return this.ufoSprite;								//sprite ufo
	}	
	
}

package tp.p1;

public class Carrier {
	// (UFO es objeto de esta clase pero tiene atributos con valor diferente.
	
	private int posX, posY;		// These attributes change over time -> init in constructor
	private int shield;		//Shield me da error si esto no es static
	private final int points;

	private final int damage = 0;
	private final boolean weapons = false;
	
	private String sprite;  		//Lo meto dentro del constructor para que sea mas comodo de usar y distinguir
	private String ufoSprite;   
	
	
	public Carrier(int posX, int posY) {
		//Class constructor

			// Carrier constructor
			this.points = 5;
			this.shield = 2;
			this.posX = posX;
			this.posY = posY;
		
		
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

	public String toString() {
		String sprite;
	
			sprite = "-<" + this.shield + ">-";
		
		return sprite;
	}	
	
}

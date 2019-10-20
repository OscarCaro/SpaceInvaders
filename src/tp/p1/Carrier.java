package tp.p1;

public class Carrier {
	
	private int posX, posY;		
	private int shield;		
	private final int points;
	
	public Carrier(int posX, int posY) {		
		this.points = 5;
		this.shield = 2;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void decrementShield() {
		this.shield--;
	}
	
	public String toString() {
		return "-<" + this.shield + ">-";
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosY() {
		return posY;
	}

	public int getShield() {
		return shield;
	}		

	public int getPoints() {
		return points;
	}	
}

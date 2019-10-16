package tp.p1;

public class Ufo {
	private int points;
	private int shield;
	private int posX;
	private int posY;
	private String sprite;
	
	public Ufo(int posX, int posY) {
		this.points = 25;
		this.shield = 1;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void newUFO(int posX, int posY) {
		new Ufo(posX, posY);
	}
	
	public void decrementShield() {
		this.shield--;
	}
	
	public int getShield() {
		return shield;
	}



	public void setShield(int shield) {
		this.shield = shield;
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
		return "<(+)>";
	}
}

package tp.p1.model;

public class Ufo {
	private int points;
	private int shield;
	private int posX;
	private int posY;
	private String sprite;
	
	public Ufo() {
		this.points = 25;
		this.shield = 1;
		this.posX = Board.COLUMNS;
		this.posY = 0;
		this.sprite = this.toString();
	}
	
	public void moveUfo() {
		this.posX--;
	}

	public String checkPos(int x, int y) {
		String str = "";
		if (this.posX == x && this.posY == y) {
			str = this.sprite;
		}
		return str;
	}
	
	public boolean outOfBoard() {
		return (this.posX < 0);
	}

	public String toString() {
		return "<(+)>";
	}
	
	public int getShield() {
		return shield;
	}
	
	public void decrementShield() {
		this.shield--;
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
	
	public int getPoints() {
		return points;
	}
}

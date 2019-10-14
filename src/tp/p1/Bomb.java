package tp.p1;

public class Bomb {
	
	private int posX, posY;
		
	public Bomb(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public String toString() {
		String sprite;
			sprite = "!";
		return sprite;
	}
}

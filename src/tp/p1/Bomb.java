package tp.p1;

public class Bomb {
	
	private int posX, posY;
	private Destroyer destroyer;
		
	public Bomb(int posX, int posY, Destroyer destroyer) {
		this.posX = posX;
		this.posY = posY;
		this.destroyer = destroyer;
		this.destroyer.setCanShoot(false);
	}
	
	public void allowDestroyerShoot() {
		this.destroyer.setCanShoot(true);
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
	
	public void outOfBoard() {
		if(this.posY > Board.ROWS) {
			this.allowDestroyerShoot();
		}
	}
}

package tp.p1.model;

public class Bomb {
	
	private int posX, posY;
	private Destroyer destroyer;
	private final String sprite = "!";
		
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
	
	public void incrementPosY() {
		this.posY++;
	}
	
	public String toString() {
		return this.sprite;
	}
	
	public boolean outOfBoard() {
		boolean out = false;
		if(this.posY > Board.ROWS) {
			this.allowDestroyerShoot();
			out = true;
		}
		return out;
	}
}

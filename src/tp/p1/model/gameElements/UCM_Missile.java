package tp.p1.model.gameElements;

public class UCM_Missile extends Weapon{
	
	private int posX;
	private int posY;	
	private final String sprite = "^";
	
	public UCM_Missile(int PosX, int PosY) {
		this.posX = PosX;
		this.posY = PosY;
	}
	
	public void decrementPosY() {
		this.posY--;
	}
	
	public String checkPos (int x, int y) {
		String str = "";
		if (this.posX == x && this.posY == y) {
			str = this.sprite;
		}
		return str;
	}
	
	public boolean outOfBoard() {	
		return this.posY < 0;
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
}

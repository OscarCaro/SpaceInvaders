package tp.p1;



public class UCM_Missile {
	private int posX;
	private int posY;
	
	private String sprite;
	
	public UCM_Missile(int PosX, int PosY) {
		this.posX = PosX;
		this.posY = PosY;
		this.sprite = "^";
	}
	
	public String toString() {
		return this.sprite;
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
	
		return (this.posY < 0);
	}
	
}

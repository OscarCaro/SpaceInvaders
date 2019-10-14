package tp.p1;

public class UCM_Missile {
	private int PosX;
	private int PosY;
	
	public UCM_Missile(int PosX, int PosY) {
		this.PosX = PosX;
		this.PosY = PosY;
	}
	
	public String toString() {
		return "^";
	}
	
	public int getPosX() {
		return PosX;
	}

	public void setPosX(int posX) {
		this.PosX = posX;
	}

	public int getPosY() {
		return PosY;
	}

	public void setPosY(int posY) {
		this.PosY = posY;
	}
	
}

package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class UCM_Missile extends Weapon implements Printable{
	
//	private int posX;
//	private int posY;	
	private final String sprite = "^";
	
	public UCM_Missile(int PosX, int PosY, Game game) {
		super(PosX, PosY, game);
	}
	
	public void decrementPosY() {
		this.setPosY(this.getPosY() - 1);
	}
	
	public String checkPos (int x, int y) {
		String str = "";
		if (this.getPosX() == x && this.getPosY() == y) {
			str = this.sprite;
		}
		return str;
	}
	
	public boolean outOfBoard() {	
		return this.getPosY() < 0;
	}
	
//	public int getPosX() {
//		return posX;
//	}
//
//	public void setPosX(int posX) {
//		this.posX = posX;
//	}
//
//	public int getPosY() {
//		return posY;
//	}
//
//	public void setPosY(int posY) {
//		this.posY = posY;
//	}	
}

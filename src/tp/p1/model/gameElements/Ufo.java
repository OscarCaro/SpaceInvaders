package tp.p1.model.gameElements;

import tp.p1.model.Board;
import tp.p1.model.Game;

public class Ufo extends EnemyShip {
//	private int points;
	//private int shield;
//	private int posX;
//	private int posY;
	private String sprite;
	
	public Ufo(Game game) {
		super(Board.COLUMNS, 0, game, 1, 25);
		
	}
	
	public void moveUfo() {
		this.setPosX(this.getPosX() - 1);
	}

	public String checkPos(int x, int y) {
		String str = "";
		if (this.getPosX() == x && this.getPosY() == y) {
			str = this.sprite;
		}
		return str;
	}
	
	public boolean outOfBoard() {
		return (this.getPosX() < 0);
	}

	public String toString() {
		return "<(+)>";
	}
	
//	public int getShield() {
//		return shield;
//	}
//	
//	public void decrementShield() {
//		this.shield--;
//	}
	
//	public void setShield(int shield) {
//		this.shield = shield;
//	}

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
	
//	public int getPoints() {
//		return points;
//	}
}

package tp.p1.model.gameElements;

import tp.p1.model.Board;
import tp.p1.model.Game;

public class Ufo extends EnemyShip implements Printable{

	private final String sprite = "<(+)>";
	
	public Ufo(Game game) {
		super(Board.COLUMNS, 0, game, 1, 25);		
	}
	
	public void moveUfo() {
		this.setPosX(this.getPosX() - 1);
	}

	public String checkPos(int x, int y) {
		String str = "";
		if (this.getPosX() == x && this.getPosY() == y) {
			str = this.toString();
		}
		return str;
	}
	
	public boolean outOfBoard() {
		return (this.getPosX() < 0);
	}

	public String toString() {
		return this.sprite;
	}

}

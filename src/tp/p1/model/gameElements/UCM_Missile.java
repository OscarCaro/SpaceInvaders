package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class UCM_Missile extends Weapon implements Printable{

	private final String sprite = "^";
	
	public UCM_Missile(int PosX, int PosY, Game game) {
		super(PosX, PosY, game);
	}
	
	public void moveUp() {
		this.move(Direction.UP, 1);
	}
	
	public String toString() {
		return this.sprite;
	}
	
	public boolean outOfBoard() {	
		return this.getPosY() < 0;
	}
	
}

package tp.p1.model.gameElements;

import tp.p1.model.Board;
import tp.p1.model.Direction;
import tp.p1.model.Game;

public class Ufo extends EnemyShip implements Printable{

	private final String sprite = "<(+)>";
	
	public Ufo(Game game) {
		super(Board.COLUMNS, 0, game, 1, 25);		
	}
	
	public void moveUfo() {
		this.move(Direction.LEFT, 1);
	}
	
	public boolean outOfBoard() {
		return (this.getPosX() < 0);
	}

	public String toString() {
		return this.sprite;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

}

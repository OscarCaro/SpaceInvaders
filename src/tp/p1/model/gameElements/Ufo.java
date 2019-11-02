package tp.p1.model.gameElements;

import tp.p1.model.Board;
import tp.p1.model.Direction;
import tp.p1.model.Game;

public class Ufo extends EnemyShip{

	private final String sprite = "<(+)>";
	
	public Ufo(Game game) {
		super(Game.COLUMNS, 0, game, 1, 25);		
	}
	
	@Override
	public void move() {
		this.move(Direction.LEFT, 1);
	}

	@Override
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

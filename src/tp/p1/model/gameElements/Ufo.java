package tp.p1.model.gameElements;

import tp.p1.model.Board;
import tp.p1.model.Direction;
import tp.p1.model.Game;

public class Ufo extends EnemyShip{
	
	private static boolean exists;

	private final String sprite = "<(+)>";
	
	public Ufo(Game game) {
		super(Game.COLUMNS, 0, game, 1, 25, "U");	
		setExists(true);
	}
	
	@Override
	public void move() {
		this.specificMove(Direction.LEFT, 1);
	}

	@Override
	public String toString() {
		return this.sprite;
	}

	@Override
	public void onDelete() {
		this.game.receivePoints(this.getPoints());
		setExists(false);
	}
	
	public String stringify() {
		String result="";		
		result += super.stringify() +";"+ exists;
		return result;
	}
	
	public static boolean exists() {
		return exists;
	}

	public static void setExists(boolean exists) {
		Ufo.exists = exists;
	}
	
	//We assume that a shockwave does not affect the ufo to avoid an infinite shockwave glitch
}

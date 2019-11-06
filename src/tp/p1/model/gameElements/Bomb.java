package tp.p1.model.gameElements;

import tp.p1.model.Board;
import tp.p1.model.Direction;
import tp.p1.model.Game;

public class Bomb extends Weapon{
	
	private Destroyer destroyer;
	private final String sprite = "!";
		
	public Bomb(int posX, int posY, Game game, Destroyer destroyer) {
		super(posX, posY, game, 1);
		this.destroyer = destroyer;
		
		this.destroyer.setCanShoot(false);
	}
	
	
	@Override
	public void move() {
		this.specificMove(Direction.DOWN, 1);
	}
	
	@Override
	public String toString() {
		return this.sprite;
	}
	
	

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean outOfBoard() {			// ----> use isOut in GameElem class
		boolean out = false;
		if(this.getPosY() > Game.ROWS) {
			this.allowDestroyerShoot();
			out = true;
		}
		return out;
	}
	
	public void allowDestroyerShoot() {
		this.destroyer.setCanShoot(true);
	}
	
	
}

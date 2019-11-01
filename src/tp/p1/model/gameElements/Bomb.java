package tp.p1.model.gameElements;

import tp.p1.model.Board;
import tp.p1.model.Direction;
import tp.p1.model.Game;

public class Bomb extends Weapon implements Printable{
	
	private Destroyer destroyer;
	private final String sprite = "!";
		
	public Bomb(int posX, int posY, Game game, Destroyer destroyer) {
		super(posX, posY, game);
		this.destroyer = destroyer;
		
		this.destroyer.setCanShoot(false);
	}
	
	public void allowDestroyerShoot() {
		this.destroyer.setCanShoot(true);
	}
	
	public void moveDown() {
		this.move(Direction.DOWN, 1);
	}
	
	public String toString() {
		return this.sprite;
	}
	
	public boolean outOfBoard() {
		boolean out = false;
		if(this.getPosY() > Board.ROWS) {
			this.allowDestroyerShoot();
			out = true;
		}
		return out;
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

package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class UCM_Missile extends Weapon{

	private final String sprite = "^";
	
	public UCM_Missile(int PosX, int PosY, Game game) {
		super(PosX, PosY, game, 1);
	}
	
	@Override
	public void move() {
		this.move(Direction.UP, 1);
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

//	public boolean outOfBoard() {			----> use isOut in GameElem class
//		return this.getPosY() < 0;
//	}
}

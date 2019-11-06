package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class UCM_Missile extends Weapon{
	public static final int DAMAGE = 1;
	private final String sprite = "^";
	
	public UCM_Missile(int PosX, int PosY, Game game) {
		super(PosX, PosY, game, 1, DAMAGE);
	}
	
	@Override
	public void move() {
		this.specificMove(Direction.UP, 1);
	}
	
	@Override
	public String toString() {
		return this.sprite;
	}
	

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean performAttack(GameElements other) {
		boolean attacked = false;
		if(this.isOnPosition(other.getPosX(), other.getPosY() - 1)) {
			other.receiveMissileAttack(DAMAGE);
			this.onDelete();
			attacked = true;
		}
		
		return attacked;
	}
	
	public boolean receiveBombAttack(int damage) {
		this.decrementShield(damage);
		
		return true;
	}

//	public boolean outOfBoard() {			----> use isOut in GameElem class
//		return this.getPosY() < 0;
//	}
}

package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class UCM_Missile extends Weapon{
	public static final int DAMAGE = 1;
	private final String sprite = "^";
	
	public UCM_Missile(int PosX, int PosY, Game game) {
		super(PosX, PosY, game, 1, "M");
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
		this.game.enableMissile();
	}
	
	public String stringify() {
		String result="";		
		result += super.stringify();
		return result;
	}
	
	@Override
	public boolean performAttack(GameElements other) {
		// Missile has already moved before calling to this method
		boolean attacked = false;
		if(this.isOnPosition(other.getPosX(), other.getPosY()) && other.receiveMissileAttack(DAMAGE)) {
			attacked = true;
		}
		
		return attacked;
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.decrementShield(damage);		
		return true;
	}

}

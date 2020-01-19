package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class MegaMissile extends Weapon{

	public static final int DAMAGE = 2;
	public static final int COST = 40;
	
	public MegaMissile(int posX, int posY, Game game) {
		super(posX, posY, game, 2, "M");
	}

	@Override
	public void onDelete() {
		game.enableMissile();
	}

	@Override
	public void move() {
		specificMove(Direction.UP, 1);
	}

	@Override
	public String toString() {
		
		return "|^|";
	}
	
	@Override
	public boolean performAttack(GameElements other) {
		// Missile has already moved before calling to this method
		boolean attacked = false;
		if(this.isOnPosition(other.getPosX(), other.getPosY()) && other.receiveSuperMissileAttack(DAMAGE)) {
			attacked = true;
		}
		
		return attacked;
	}
	
	public boolean receiveBombAttack(int damage) {
		this.decrementShield(damage);		
		return true;
	}
}

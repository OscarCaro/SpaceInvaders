package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class Supermissile extends Weapon{
	public static final int DAMAGE = 2;
	public static final int COST = 20;
	private final String sprite = "*^*";
	
	public Supermissile(int PosX, int PosY, Game game) {
		super(PosX, PosY, game, 1, "X");
	}

	@Override
	public void onDelete() {
		this.game.enableMissile();
		
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
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.decrementShield(damage);		
		return true;
	}
	
	@Override
	public void move() {
		this.specificMove(Direction.UP, 1);
	}

	@Override
	public String toString() {
		return this.sprite;
	}
}

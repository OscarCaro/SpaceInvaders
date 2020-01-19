package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;


public class SuperBomb extends Weapon {
	
	private final int DAMAGE = 2;
	
	private SuperDestroyer sDestroyer;

	public SuperBomb(int posX, int posY, Game game, SuperDestroyer sDestroyer) {
		super(posX, posY, game, 1, "Q");
		this.sDestroyer = sDestroyer;
	}

	@Override
	public void onDelete() {
		allowShipShoot();

	}
	
	@Override
	public boolean performAttack(GameElements other) {
		// Bomb has already moved before calling to this method
		boolean attacked = false;
		if((this.isOnPosition(other.getPosX(), other.getPosY())) && other.receiveBombAttack(DAMAGE)){ 
			attacked = true;
		}
		
		return attacked;
	}
	

	@Override
	public void move() {
		this.specificMove(Direction.DOWN, 1);

	}
	
	public boolean receiveMissileAttack(int damage) {
		this.decrementShield(damage);
		return super.receiveMissileAttack(damage);
	}

	@Override
	public String toString() {
		return "*!*";
	}

	public void allowShipShoot() {
		this.sDestroyer.setCanShoot(true);
	}
}

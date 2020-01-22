package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class SmartBomb extends Weapon {
	
	private final String sprite = "*";
	public static final int DAMAGE = 1;	

	public SmartBomb(int posX, int posY, Game game) {
		super(posX, posY, game, DAMAGE, "S");
	}
	
	@Override
	public boolean performAttack(GameElements other) {
		// SmartBomb has already moved before calling to this method
		boolean attacked = false;
		if((this.isOnPosition(other.getPosX(), other.getPosY())) && other.receiveSmartBombAttack(DAMAGE)){ 
			attacked = true;
		}
		
		return attacked;
	}
	
	@Override
	public boolean receiveMissileAttack(int damage) {
		this.decrementShield(damage);		
		return true;
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.decrementShield(damage);		
		return true;
	}
	
	@Override
	public boolean receiveSuperMissileAttack(int damage) {
		this.decrementShield(damage);		
		return true;
	}

	@Override
	public void onDelete() {
		
	}

	@Override
	public void move() {
		this.specificMove(Direction.DOWN, 1);		
	}

	@Override
	public String toString() {
		return this.sprite;
	}

}

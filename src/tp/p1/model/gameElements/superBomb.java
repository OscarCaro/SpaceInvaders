package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class superBomb extends Weapon {
	
	private Commander commander;
	private String sprite = "*!*";
	public static final int DAMAGE = 2;	

	public superBomb(int posX, int posY, Game game, Commander commander) {
		super(posX, posY, game, 1, "K");
		this.commander = commander;
		this.commander.setCanShoot(false);
	}
	
	public boolean performAttack(GameElements other) {
		// Bomb has already moved before calling to this method
		boolean attacked = false;
		if((this.isOnPosition(other.getPosX(), other.getPosY())) && other.receiveBombAttack(DAMAGE)){ 
			attacked = true;
		}
		
		return attacked;
	}
	
	public boolean receiveMissileAttack(int damage) {
		this.decrementShield(damage);		
		return true;
	}
	
	@Override
	public void onDelete() {
		allowCommanderShoot();
	}
	
	public void allowCommanderShoot() {
		this.commander.setCanShoot(true);
	}	
	
	@Override
	public void move() {
		this.specificMove(Direction.DOWN, 1);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.sprite;
	}

}

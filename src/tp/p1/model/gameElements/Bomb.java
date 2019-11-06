package tp.p1.model.gameElements;

import tp.p1.model.Board;
import tp.p1.model.Direction;
import tp.p1.model.Game;

public class Bomb extends Weapon{
	
	private Destroyer destroyer;
	private final String sprite = "!";
	public static final int DAMAGE = 1;	
		
	public Bomb(int posX, int posY, Game game, Destroyer destroyer) {
		super(posX, posY, game, 1, DAMAGE);
		this.destroyer = destroyer;
		
		this.destroyer.setCanShoot(false);
	}
	
	@Override
	public boolean performAttack(GameElements other) {
		boolean attacked = false;
		if((other.isOnPosition(other.getPosX(), other.getPosY() + 1))){ 
			other.receiveMissileAttack(DAMAGE);
			this.onDelete();
			attacked = true;
		}
		
		return attacked;
	}
	
	public boolean receiveMissileAttack(int damage) {
		this.decrementShield(damage);
		
		return true;
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

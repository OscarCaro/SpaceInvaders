package tp.p1.model.gameElements;

import tp.p1.model.Game;

public abstract class Weapon extends GameElements {
	protected int damage;
	
	public Weapon (int posX, int posY, Game game, int shield, int damage) {
		super(posX, posY, game, shield);
		this.damage = damage;
	}
	
	@Override
	public boolean performAttack(GameElements other) {
		boolean attacked = false;
		if(other.getPosY() == this.getPosY() + 1) {
			other.decrementShield(this.damage);
			this.onDelete();
			attacked = true;
		}
		
		return attacked;
	}
}

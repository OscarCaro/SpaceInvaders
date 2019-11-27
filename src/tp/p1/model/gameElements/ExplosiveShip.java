package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class ExplosiveShip extends AlienShip {
	
	public static final int DAMAGE = 1;

	public ExplosiveShip(int posX, int posY, Game game, int shield) {
		super(posX, posY, game, shield, 5, "E");
	}

	@Override
	public void onDelete() {
		this.game.explosiveShipDead(this.getPosX(), this.getPosY());
		AlienShip.decrementAlienCounter();
		this.game.receivePoints(this.getPoints());
	}
	
	public String stringify() {
		String result="";		
		result += super.stringify();
		return result;
	}

	@Override
	public String toString() {
		return "*<" + this.getShield() + ">*";
	}

}

package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class SuperDestroyer extends AlienShip {
	
	private boolean canShoot;
	public SuperDestroyer(int posX, int posY, Game game, int shield) {
		super(posX, posY, game, shield, 20, "S");
		canShoot = true;
		
	}


	@Override
	public String toString() {
		return "!_" + this.getShield() + "_!";
	}

	public void computerAction() {
		if(canShoot && IExecuteRandomActions.canGenerateBomb(this.game)) {
			game.addObject(new SuperBomb(this.getPosX(), this.getPosY(), this.game, this));
		}	
	}

	@Override
	public void onDelete() {
		AlienShip.decrementAlienCounter();
		this.game.receivePoints(this.getPoints());
	}

	public boolean isCanShoot() {
		return canShoot;
	}

	public void setCanShoot(boolean canShoot) {
		this.canShoot = canShoot;
	}
}

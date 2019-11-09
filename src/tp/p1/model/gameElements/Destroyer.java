package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Destroyer extends AlienShip {

	private boolean canShoot;
	
	public Destroyer (int posX, int posY, Game game) {
		super(posX, posY, game, 1, 10);
		this.canShoot = true;
	}	
	
	@Override
	public String toString() {
		return "!<" + this.getShield() + ">!";
	}

	@Override
	public void computerAction() {
		if(canShoot && IExecuteRandomActions.canGenerateBomb(this.game)) {
			game.addObject(new Bomb(this.getPosX(), this.getPosY(), game, this));
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

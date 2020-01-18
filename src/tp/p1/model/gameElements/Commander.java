package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Commander extends AlienShip {
	private boolean canShoot;
	public Commander(int posX, int posY, Game game) {
		super(posX, posY, game, 3, 60, "B");
		this.canShoot = true;
		
	}
	@Override
	public void computerAction() {
		if(canShoot && IExecuteRandomActions.canGenerateSuperBomb(this.game)) {
			game.addObject(new superBomb(this.getPosX(), this.getPosY(), game, this));
		}	
	}
	public String toString() {
		return "||" + this.getShield() + "||";
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

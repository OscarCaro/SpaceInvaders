package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Destroyer extends AlienShip implements Printable{

	private boolean canShoot;
	
	public Destroyer (int posX, int posY, Game game) {
		super(posX, posY, game, 1, 10);
		this.canShoot = true;
	}	
	
	public String toString() {
		return "!<" + this.getShield() + ">!";
	}
	
	public boolean isCanShoot() {
		return canShoot;
	}

	public void setCanShoot(boolean canShoot) {
		this.canShoot = canShoot;
	}

}

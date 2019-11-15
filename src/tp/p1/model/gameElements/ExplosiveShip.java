package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class ExplosiveShip extends AlienShip {

	public ExplosiveShip(int posX, int posY, Game game, int shield, int points) {
		super(posX, posY, game, 2, 5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onDelete() {
		AlienShip.decrementAlienCounter();
		this.game.receivePoints(this.getPoints());
	}

	@Override
	public String toString() {
		return "*<" + this.getShield() + ">*";
	}

}

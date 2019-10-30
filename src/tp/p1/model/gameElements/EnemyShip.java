package tp.p1.model.gameElements;

import tp.p1.model.Game;

public abstract class EnemyShip extends Ship {
	private int points;
	
	public EnemyShip(int posX, int posY, Game game, int shield, int points) {
		super(posX, posY, game, shield);
		this.points = points;
	}
	
	public int getPoints() {
		return points;
	}

}

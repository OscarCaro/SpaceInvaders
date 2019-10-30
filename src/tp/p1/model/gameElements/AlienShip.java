package tp.p1.model.gameElements;

import tp.p1.model.Game;

public abstract class AlienShip extends EnemyShip {
	
	public AlienShip (int posX, int posY, Game game, int shield, int points) {
		super(posX, posY, game, shield, points);
	}
}

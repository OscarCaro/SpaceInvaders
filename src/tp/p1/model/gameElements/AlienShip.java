package tp.p1.model.gameElements;

import tp.p1.model.Game;

public abstract class AlienShip extends EnemyShip {
	
	public AlienShip (int posX, int posY, Game game, int shield, int points) {
		super(posX, posY, game, shield, points);
	}

	public static boolean allDead() {
		boolean dead = false;
		//ToDo: Extend comparison for shield == 0 for all VALID alien ships | Ships counter == 0
		return dead;
	}

	public static boolean haveLanded() {
		// Previous "CheckEnemiesInBottomRow()
		return false;
	}
}

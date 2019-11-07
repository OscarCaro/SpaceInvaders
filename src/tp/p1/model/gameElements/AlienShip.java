package tp.p1.model.gameElements;

import tp.p1.model.Game;

public abstract class AlienShip extends EnemyShip {
	protected static int alienCounter;
	
	public AlienShip (int posX, int posY, Game game, int shield, int points) {
		super(posX, posY, game, shield, points);
		incrementCounter();
	}
	
	@Override
	public boolean receiveShockWaveAttack(int damage) {
		this.decrementShield(damage);		
		return true;
	}
	
	public static boolean allDead() {		
		return (alienCounter <= 0);
	}

	public static boolean haveLanded() {
		// Previous "CheckEnemiesInBottomRow()
		return false;
	}
	
	public static void resetCounter() {
		alienCounter = 0;
	}
	
	protected static void incrementCounter() {
		alienCounter++;
	}
	
	protected static void decrementCounter() {
		alienCounter--;
	}
	
	public static int getCounter() {
		return alienCounter;
	}
}

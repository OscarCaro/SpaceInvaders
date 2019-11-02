package tp.p1.model.gameElements;

import tp.p1.model.Direction;

public interface IPlayerController {
	// Player actions
	public boolean movePlayer (int numCells, Direction direction);
	public boolean shootMissile();
	public boolean shockWave();
	// Callbacks 
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}

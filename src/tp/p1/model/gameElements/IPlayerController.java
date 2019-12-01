package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.exceptions.MissileAlreadyOnBoardException;
import tp.p1.model.exceptions.SuperMissileNotBoughtException;

public interface IPlayerController {
	// Player actions
	public boolean movePlayer (int numCells, Direction direction);
	public boolean shootMissile();
	public boolean shockWave();
	public boolean buySuperMissile();
	public boolean shootSuperMissile() throws SuperMissileNotBoughtException, MissileAlreadyOnBoardException;
	// Callbacks 
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();

}

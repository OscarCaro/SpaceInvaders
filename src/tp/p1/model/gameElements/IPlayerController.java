package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.exceptions.commandExecuteExceptions.MissileAlreadyOnBoardException;
import tp.p1.model.exceptions.commandExecuteExceptions.NoShockwaveException;
import tp.p1.model.exceptions.commandExecuteExceptions.ScoreBuySupermissileException;
import tp.p1.model.exceptions.commandExecuteExceptions.SuperMissileNotBoughtException;

public interface IPlayerController {
	// Player actions
	public void movePlayer (int numCells, Direction direction);
	public void shootMissile() throws MissileAlreadyOnBoardException;
	public void shockWave() throws NoShockwaveException;
	public void buySuperMissile() throws ScoreBuySupermissileException;
	public void shootSuperMissile() throws SuperMissileNotBoughtException, MissileAlreadyOnBoardException;
	// Callbacks 
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();

}

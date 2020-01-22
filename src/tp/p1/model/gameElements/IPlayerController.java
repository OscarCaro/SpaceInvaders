package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.exceptions.commandExecuteExceptions.*;

public interface IPlayerController {
	// Player actions
	public void movePlayer (int numCells, Direction direction);
	public void shootMissile() throws MissileAlreadyOnBoardException;
	public void shockWave() throws NoShockwaveException;
	public void buySuperMissile() throws ScoreBuySupermissileException;
	public void shootSuperMissile() throws SuperMissileNotBoughtException, MissileAlreadyOnBoardException;
	public void shootSniperAttack(int posX, int posY, int damage) throws NotEnoughPointsException, CannotShootObjectException, NothingToKillException;
	// Callbacks 
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();

}

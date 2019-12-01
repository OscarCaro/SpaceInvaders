package tp.p1.model.exceptions.commandExecuteExceptions;

import tp.p1.model.gameElements.Supermissile;

public class ScoreBuySupermissileException extends CommandExecuteException {
	public static final String MESSAGE = "Cannot buy supermissile: Not enough score (requires "
			+ Supermissile.COST + " points)";

	public ScoreBuySupermissileException() {
		super(MESSAGE);
	}
}

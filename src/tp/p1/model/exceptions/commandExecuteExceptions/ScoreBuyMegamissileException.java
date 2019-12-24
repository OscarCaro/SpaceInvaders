package tp.p1.model.exceptions.commandExecuteExceptions;

import tp.p1.model.gameElements.Megamissile;

public class ScoreBuyMegamissileException extends CommandExecuteException {
	public static final String MESSAGE = "Cannot buy megamissile: Not enough score (requires "
			+ Megamissile.COST + " points)";

	public ScoreBuyMegamissileException() {
		super(MESSAGE);
	}
}

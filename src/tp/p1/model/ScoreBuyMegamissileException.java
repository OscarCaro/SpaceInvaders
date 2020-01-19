package tp.p1.model;

import tp.p1.model.exceptions.commandExecuteExceptions.CommandExecuteException;

public class ScoreBuyMegamissileException extends CommandExecuteException {
	public static final String MESSAGE = "Not enough points to buy megamissile";

	public ScoreBuyMegamissileException() {
		super(MESSAGE);
	}
}

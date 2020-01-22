package tp.p1.model.exceptions.commandExecuteExceptions;

import tp.p1.model.gameElements.Supermissile;

public class NothingToKillException extends CommandExecuteException{
	public static final String MESSAGE = "Nothing to hit in that position";

	public NothingToKillException() {
		super(MESSAGE);
	}
}

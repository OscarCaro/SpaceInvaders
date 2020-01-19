package tp.p1.model;

import tp.p1.model.exceptions.commandExecuteExceptions.CommandExecuteException;

public class MegaMissileNotBoughtException extends CommandExecuteException {
	public static final String MESSAGE = "megamissile not bought";

	public MegaMissileNotBoughtException() {
		super(MESSAGE);
	}
}

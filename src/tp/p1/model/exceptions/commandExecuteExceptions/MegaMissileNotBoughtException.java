package tp.p1.model.exceptions.commandExecuteExceptions;

public class MegaMissileNotBoughtException extends CommandExecuteException{
	public static final String MESSAGE = "megamissile not bought";

	public MegaMissileNotBoughtException() {
		super(MESSAGE);
	}
}

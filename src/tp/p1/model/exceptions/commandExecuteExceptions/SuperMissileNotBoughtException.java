package tp.p1.model.exceptions.commandExecuteExceptions;

public class SuperMissileNotBoughtException extends CommandExecuteException{
	
	public static final String MESSAGE = "supermissile not bought";

	public SuperMissileNotBoughtException() {
		super(MESSAGE);
	}
}

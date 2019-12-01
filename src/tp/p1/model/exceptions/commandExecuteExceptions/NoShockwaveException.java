package tp.p1.model.exceptions.commandExecuteExceptions;

public class NoShockwaveException extends CommandExecuteException{
	
	public static final String MESSAGE = "Cannot release shockwave: no shockwave available";
	
	public NoShockwaveException() {
		super(MESSAGE);
	}

}

package tp.p1.model.exceptions.commandExecuteExceptions;

public class MissileAlreadyOnBoardException extends CommandExecuteException{
	
	public static final String MESSAGE = "missile already exists on board";
	
	public MissileAlreadyOnBoardException() {
		super(MESSAGE);
	}
}

package tp.p1.model.exceptions.commandExecuteExceptions;

import tp.p1.model.gameElements.GameElements;

public class CannotShootObjectException extends CommandExecuteException{
	public static final String MESSAGE = "Cannot hit: ";
	
	public CannotShootObjectException(String elementSprite) {
		super(MESSAGE + elementSprite);	// Call to toString returns the sprite
	}

}

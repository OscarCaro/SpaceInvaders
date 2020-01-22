package tp.p1.model.exceptions.commandExecuteExceptions;

import tp.p1.model.commands.SniperCommand;
import tp.p1.model.gameElements.Supermissile;

public class NotEnoughPointsException extends CommandExecuteException {
	public static final String MESSAGE = "Cannot perform sniper shoot: Not enough score (requires "
			+ SniperCommand.COST + " points per point of damage)";

	public NotEnoughPointsException() {
		super(MESSAGE);
	}
}

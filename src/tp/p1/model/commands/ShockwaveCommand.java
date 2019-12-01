package tp.p1.model.commands;

import tp.p1.model.Game;
import tp.p1.model.exceptions.commandExecuteExceptions.NoShockwaveException;

public class ShockwaveCommand extends NoParamsCommand {

	public ShockwaveCommand() {
		super("shockwave", "w", "Shockwave", "causes the UCM-Ship to release a shock wave.");
	}

	@Override
	public boolean execute(Game game) throws NoShockwaveException {
		game.shockWave();	
		return true;
	}

}

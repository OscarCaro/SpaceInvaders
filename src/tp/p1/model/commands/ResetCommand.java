package tp.p1.model.commands;

import tp.p1.model.Game;

public class ResetCommand extends NoParamsCommand {

	public ResetCommand() {
		super("reset", "r", "Reset", "starts a new game.");
	}

	@Override
	public boolean execute(Game game) {
		game.reset();			// TODO: add something so that user is asked to play again
		return false;
	}


}

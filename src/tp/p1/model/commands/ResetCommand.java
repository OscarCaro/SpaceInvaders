package tp.p1.model.commands;

import tp.p1.model.Game;

public class ResetCommand extends Command {

	public ResetCommand() {
		super("reset", "r", "Reset", "starts a new game.");
	}

	@Override
	public boolean execute(Game game) {
		game.finishGame();			// TODO: add something so that user is asked to play again
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command reset = null;
		if (commandWords.length == 1  &&  matchCommandName(commandWords[0])) {
			reset = new ResetCommand();			
		}
		return reset;
	}

}

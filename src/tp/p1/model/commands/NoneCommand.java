package tp.p1.model.commands;

import tp.p1.model.Game;

public class NoneCommand extends Command{

	public NoneCommand() {
		super("none", "n", "[none]", "skips one cycle.");
	}

	@Override
	public boolean execute(Game game) {
		return true;	// Nothing changes, but it has to print the game and increment turn
	}

	@Override
	public Command parse(String[] commandWords) {
		Command none = null;
		if (commandWords.length == 1  &&  matchCommandName(commandWords[0])) {			
			none = new NoneCommand();			
		}
		return none;
	}
}

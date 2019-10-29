package tp.p1.model.commands;

import tp.p1.model.Game;

public class ExitCommand extends Command {

	public ExitCommand() {
		super("help", "h", "Help", "terminates the program");
	}

	@Override
	public boolean execute(Game game) {
		//Print message (?)
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command exit = null;
		if (commandWords.length == 1  &&  matchCommandName(commandWords[0])) {
			exit = new ExitCommand();
		}
		return exit;
	}

}

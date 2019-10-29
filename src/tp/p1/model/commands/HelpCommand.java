package tp.p1.model.commands;

import tp.p1.model.Game;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("help", "h", "Help", "prints this help message.");
	}

	@Override
	public boolean execute(Game game) {
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command help = null;
		if (commandWords.length == 1  &&  matchCommandName(commandWords[0])) {
			help = new HelpCommand();			
		}
		return help;
	}

}

package tp.p1.model.commands;

import tp.p1.model.Command;
import tp.p1.model.Game;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("help", "h", "Help", "prints this help message.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command help = null;
		if (commandWords.length == 1) {
			if (commandWords[0].equals(super.name) || commandWords[0].equals(super.shortName)) {
				help = new HelpCommand();
			}
		}
		return null;
	}

}

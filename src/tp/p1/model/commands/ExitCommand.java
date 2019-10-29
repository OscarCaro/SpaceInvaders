package tp.p1.model.commands;

import tp.p1.model.Command;
import tp.p1.model.Game;

public class ExitCommand extends Command {

	public ExitCommand() {
		super("help", "h", "Help", "terminates the program");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command exit = null;
		if (commandWords.length == 1) {
			if (commandWords[0].equals(super.name) || commandWords[0].equals(super.shortName)) {
				exit = new ExitCommand();
			}
		}
		return exit;
	}

}

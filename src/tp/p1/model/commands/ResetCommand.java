package tp.p1.model.commands;

import tp.p1.model.Game;

public class ResetCommand extends Command {

	public ResetCommand() {
		super("reset", "r", "Reset", "starts a new game.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command reset = null;
		if (commandWords.length == 1) {
			if (commandWords[0].equals(super.name) || commandWords[0].equals(super.shortName)) {
				reset = new ResetCommand();
			}
			
		}
		return reset;
	}

}

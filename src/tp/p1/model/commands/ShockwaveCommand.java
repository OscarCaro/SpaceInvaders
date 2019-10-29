package tp.p1.model.commands;

import tp.p1.model.Game;

public class ShockwaveCommand extends Command {

	public ShockwaveCommand() {
		super("shockwave", "w", "Shockwave", "causes the UCM-Ship to release a shock wave.");
	}

	@Override
	public boolean execute(Game game) {
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command wave = null;
		if (commandWords.length == 1  &&  matchCommandName(commandWords[0])) {
			wave = new ShockwaveCommand();			
		}
		return wave;
	}

}

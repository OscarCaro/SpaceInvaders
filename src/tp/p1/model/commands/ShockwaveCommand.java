package tp.p1.model.commands;

import tp.p1.model.Game;

public class ShockwaveCommand extends Command {

	public ShockwaveCommand() {
		super("shockwave", "w", "Shockwave", "causes the UCM-Ship to release a shock wave.");
	}

	@Override
	public boolean execute(Game game) {
		boolean execute;
		if (game.useShockwave()) {		//THis also decrements enemy shields
			game.checkDeadEnemies();
			execute = true;
		}
		else {
			System.out.println("No shockwave available");
			execute = false;
		}
		return execute;
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

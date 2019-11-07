package tp.p1.model.commands;

import tp.p1.model.Game;

public class ShockwaveCommand extends NoParamsCommand {

	public ShockwaveCommand() {
		super("shockwave", "w", "Shockwave", "causes the UCM-Ship to release a shock wave.");
	}

	@Override
	public boolean execute(Game game) {
		boolean execute;
		if (game.useShockWave()) {		//THis also decrements enemy shields
									//Create new function for checking for dead enemies
			execute = true;
		}
		else {
			System.out.println("No shockwave available");
			execute = false;
		}
		return execute;
	}


}

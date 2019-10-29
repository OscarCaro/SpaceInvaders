package tp.p1.model.commands;

import tp.p1.model.Command;
import tp.p1.model.Game;

public class ShockwaveCommand extends Command {

	public ShockwaveCommand() {
		super("shockwave", "w", "Shockwave", "causes the UCM-Ship to release a shock wave.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command wave = null;
		if (commandWords.length == 1) {
			if (commandWords[0].equals(super.name) || commandWords[0].equals(super.shortName)) {
				wave = new ShockwaveCommand();
			}
		}
		return null;
	}

}

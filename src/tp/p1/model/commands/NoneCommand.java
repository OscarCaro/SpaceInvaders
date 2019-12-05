package tp.p1.model.commands;

import tp.p1.model.Game;

public class NoneCommand extends NoParamsCommand{

	public NoneCommand() {
		super("none", "n", "[none]", "skips one cycle.");
	}

	@Override
	public boolean execute(Game game) {
		return true;	// Nothing changes, but it has to print the game and increment turn
	}
}

package tp.p1.model.commands;

import tp.p1.model.Game;

public class StringifyCommand extends NoParamsCommand {

	public StringifyCommand() {
		super("Stringify", "string", "stringify", "Prints the status of the game as a plain text");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(game.stringify());
		return false;
	}

}

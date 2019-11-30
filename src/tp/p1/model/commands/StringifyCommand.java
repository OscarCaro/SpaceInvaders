package tp.p1.model.commands;

import tp.p1.model.Game;
import tp.p1.view.PrinterTypes;

public class StringifyCommand extends NoParamsCommand {

	public StringifyCommand() {
		super("Stringify", "str", "stringify", "Prints the status of the game as a plain text");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(PrinterTypes.STRINGIFIER.getObject(game));
		return false;
	}

}

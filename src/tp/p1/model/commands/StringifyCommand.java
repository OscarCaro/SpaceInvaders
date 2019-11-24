package tp.p1.model.commands;

import tp.p1.model.Game;

public class StringifyCommand extends NoParamsCommand {

	public StringifyCommand(String name, String shortName, String commandText, String helpText) {
		super(name, shortName, commandText, helpText);
	}

	@Override
	public boolean execute(Game game) {
		
		return false;
	}

}

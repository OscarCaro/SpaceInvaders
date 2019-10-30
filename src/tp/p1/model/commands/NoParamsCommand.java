package tp.p1.model.commands;

import tp.p1.model.Game;

public abstract class NoParamsCommand extends Command {
	
	public NoParamsCommand(String name, String shortName, String commandText, String helpText) {
		super(name, shortName, commandText, helpText);
	}
	
	public abstract boolean execute(Game game);
	
	public Command parse(String[] commandWords) {
		Command cmd = null;
		if (commandWords.length == 1  &&  matchCommandName(commandWords[0])) {
			cmd = this;			
		}
		return cmd;
	}
}

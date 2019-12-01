package tp.p1.model.commands;

import tp.p1.model.Game;
import tp.p1.model.exceptions.CommandParseException;
import tp.p1.model.exceptions.commandExecuteExceptions.CommandExecuteException;

public class LoadCommand extends Command{

	public LoadCommand() {
		super("load", "ld", "Load", "loads the stored state of the game from a file");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		return null;
	}

}

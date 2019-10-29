package tp.p1.model.commands;

import tp.p1.model.Game;

public class ListCommand extends Command {

	public ListCommand() {
		super("list", "l", "List", "displays the list of ship types in the game");
	}

	@Override
	public boolean execute(Game game) {
		return false; 	// only shows the list, no cycle increment nor game print
	}

	@Override
	public Command parse(String[] commandWords) {
		Command list = null;
		if (commandWords.length == 1  &&  matchCommandName(commandWords[0])) {
			list = new ListCommand();			
		}
		return list;
	}	

}

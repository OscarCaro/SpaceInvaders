package tp.p1.model.commands;

import tp.p1.model.Command;
import tp.p1.model.Game;

public class ListCommand extends Command {

	public ListCommand() {
		super("list", "l", "List", "displays the list of ship types in the game \n");
	}

	@Override
	public boolean execute(Game game) {
		return false; 	// only shows the list
	}

	@Override
	public Command parse(String[] commandWords) {
		Command list = null;
		if (commandWords.length == 1) {
			if (commandWords[0].equals(super.name) || commandWords[0].equals(super.shortName)) {
				list = new ListCommand();
			}
		}
		return list;
	}
	

}

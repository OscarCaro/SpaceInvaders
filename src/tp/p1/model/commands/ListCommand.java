package tp.p1.model.commands;

import tp.p1.model.Game;
import tp.p1.model.utils.CommandGenerator;

public class ListCommand extends Command {

	public ListCommand() {
		super("list", "l", "List", "displays the list of ship types in the game");
	}

	@Override
	public boolean execute(Game game) {
		printList();
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
	
	private void printList() {
		// It should not be hardcoded
		// It should use the game object to find each type of ship and get its data
		// For better scalability of code
		System.out.println("-<x>-: Points: 5 - Damage: 0 - Resistence: 2");
		System.out.println("!<x>!: Points: 10 - Damage: 1 - Resistence: 1");
		System.out.println("<(+)>: Points: 25 - Damage: 0 - Resistence: 1");
		System.out.println("/-^-\\: Damage: 1 - Resistence: 3");
	}

}

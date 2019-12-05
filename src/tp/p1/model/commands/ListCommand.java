package tp.p1.model.commands;

import tp.p1.model.Game;

public class ListCommand extends NoParamsCommand {

	public ListCommand() {
		super("list", "l", "List", "displays the list of ship types in the game");
	}

	@Override
	public boolean execute(Game game) {
		printList();
		return false; 	// only shows the list, no cycle increment nor game print
	}

	private void printList() {
		System.out.println("-<x>-: Points: 5 - Damage: 0 - Resistence: 2");
		System.out.println("*<x>*: Points: 5 - Damage: 1 - Resistence: 2");
		System.out.println("!<x>!: Points: 10 - Damage: 1 - Resistence: 1");
		System.out.println("<(+)>: Points: 25 - Damage: 0 - Resistence: 1");
		System.out.println("/-^-\\: Damage: 1 - Resistence: 3");
	}

}

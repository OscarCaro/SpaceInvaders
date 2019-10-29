package tp.p1.model.commands;

import tp.p1.model.Command;
import tp.p1.model.Game;

public class MoveCommand extends Command {

	public MoveCommand() {
		super("move", "m", "Move", "causes the UCM-Ship to move as indicated.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command move = null;
		if (commandWords.length == 3) {
			if (commandWords[0].equals(super.name) || commandWords[0].equals(super.shortName)) {
				move = new MoveCommand();
			}
		}
		return move;
	}

}

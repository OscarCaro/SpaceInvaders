package tp.p1.model.commands;

import tp.p1.model.Game;

public class MoveCommand extends Command {

	public MoveCommand() {
		super("move", "m", "Move", "causes the UCM-Ship to move as indicated.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		//Check whether it goes left or right and the number of cells based on command
		
		game.moveUcmShip(true, false, 1); //CASE FOR MOVE LEFT 1
		
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

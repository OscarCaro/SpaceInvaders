package tp.p1.model.commands;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class MoveCommand extends Command {
	
	private Direction dir;
	private int numOfCells;

	public MoveCommand() {
		super("move", "m", "Move", "causes the UCM-Ship to move as indicated.");
	}
	
	public MoveCommand(int numOfCells, Direction dir) {
		super("move", "m", "Move", "causes the UCM-Ship to move as indicated.");
		this.numOfCells = numOfCells;
		this.dir = dir;
	}

	@Override
	public boolean execute(Game game) {
		return game.movePlayer(this.numOfCells, dir);
	}
	
	@Override
	public Command parse(String[] commandWords) {
		Command move = null;
		if (commandWords.length == 3  && matchCommandName(commandWords[0])) {
						
			if (commandWords[1].equalsIgnoreCase("left")) {
				
				if (commandWords[2].equalsIgnoreCase("1")) {
					move = new MoveCommand(1, dir.LEFT);
				}
				else if (commandWords[2].equalsIgnoreCase("2")) {
					move = new MoveCommand(2, dir.LEFT);
				}
				
			}
			else if (commandWords[1].equalsIgnoreCase("right")) {
				
				if (commandWords[2].equalsIgnoreCase("1")) {
					move = new MoveCommand(1, dir.RIGHT);
				}
				else if (commandWords[2].equalsIgnoreCase("2")) {
					move = new MoveCommand(2, dir.RIGHT);
				}
				
			}		
			
		}
		return move;
	}

}

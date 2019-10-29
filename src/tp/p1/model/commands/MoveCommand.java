package tp.p1.model.commands;

import tp.p1.model.Game;

public class MoveCommand extends Command {
	
	private boolean left;
	private boolean right;
	private int numOfCells;

	public MoveCommand() {
		super("move", "m", "Move", "causes the UCM-Ship to move as indicated.");
	}
	
	public MoveCommand(boolean left, boolean right, int numOfCells) {
		super("move", "m", "Move", "causes the UCM-Ship to move as indicated.");
		this.left = left;
		this.right = right;
		this.numOfCells = numOfCells;
	}

	@Override
	public boolean execute(Game game) {
		game.moveUcmShip(this.left, this.right, this.numOfCells);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command move = null;
		if (commandWords.length == 3  && matchCommandName(commandWords[0])) {
						
			if (commandWords[1].equalsIgnoreCase("left")) {
				
				if (commandWords[2].equalsIgnoreCase("1")) {
					move = new MoveCommand(true, false, 1);
				}
				else if (commandWords[2].equalsIgnoreCase("2")) {
					move = new MoveCommand(true, false, 2);
				}
				
			}
			else if (commandWords[1].equalsIgnoreCase("right")) {
				
				if (commandWords[2].equalsIgnoreCase("1")) {
					move = new MoveCommand(false, true, 1);
				}
				else if (commandWords[2].equalsIgnoreCase("2")) {
					move = new MoveCommand(false, true, 2);
				}
				
			}		
			
		}
		return move;
	}

}

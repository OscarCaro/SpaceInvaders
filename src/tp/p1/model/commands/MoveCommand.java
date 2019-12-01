package tp.p1.model.commands;

import tp.p1.model.Direction;
import tp.p1.model.Game;
import tp.p1.model.exceptions.CommandParseException;

public class MoveCommand extends Command {
	
	private Direction dir;
	private int numOfCells;
	public static final String CORRECTFORMAT = "Usage: move <right|left> <1|2>";
	public static final String ERRORDIRECTION = "Direction must be <right|left>";
	public static final String ERRORDISTANCE = "Distance must be <1|2>";

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
		game.movePlayer(this.numOfCells, dir);
		return true;
	}
	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException{
		Command move = null;
		
		if (commandWords.length > 0 && matchCommandName(commandWords[0])){
			// The command starts by "move"
			if (commandWords.length == 3) {
				if (commandWords[1].equalsIgnoreCase("left")) {
					
					if (commandWords[2].equalsIgnoreCase("1")) {
						move = new MoveCommand(1, Direction.LEFT);
					}
					else if (commandWords[2].equalsIgnoreCase("2")) {
						move = new MoveCommand(2, Direction.LEFT);
					}
					else {
						// Wrong distance parameter
						throw new CommandParseException(CommandParseException.WRONGFORMATOFARGS 
														+ ". " + ERRORDISTANCE);
					}
					
				}
				else if (commandWords[1].equalsIgnoreCase("right")) {
					
					if (commandWords[2].equalsIgnoreCase("1")) {
						move = new MoveCommand(1, Direction.RIGHT);
					}
					else if (commandWords[2].equalsIgnoreCase("2")) {
						move = new MoveCommand(2, Direction.RIGHT);
					}
					else {
						// Wrong distance parameter
						throw new CommandParseException(CommandParseException.WRONGFORMATOFARGS 
														+ ". " + ERRORDISTANCE);
					}
					
				}
				else {
					// Wrong direction parameter
					throw new CommandParseException(CommandParseException.WRONGFORMATOFARGS 
													+ ". " + ERRORDIRECTION);
				}
			}
			else {
				// Wrong num of parameters
				throw new CommandParseException(CommandParseException.WRONGNUMOFARGS 
												+ ". " + CORRECTFORMAT);
			}
		}
		
		return move;
	}

}

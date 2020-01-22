package tp.p1.model.commands;

import tp.p1.model.Direction;
import tp.p1.model.Game;
import tp.p1.model.exceptions.CommandParseException;
import tp.p1.model.exceptions.commandExecuteExceptions.CommandExecuteException;

public class SniperCommand extends Command{
	
	public static final int COST = 5;
	
	public static final String CORRECTFORMAT = "Usage: sniper <posX> <posY> <damage>";
	public static final String ERRORPOSITION = "The position values must correspond to a cell of the board";
	public static final String ERRORDAMAGE = "The damage must be a positive integer value";
	
	private int posX, posY, damage;
	
	public SniperCommand() {
		super("sniper", "sn", "Sniper", "shoots at a given position");
	}
	public SniperCommand(int posX, int posY, int damage) {
		super("sniper", "sn", "Sniper", "shoots at a given position");
		this.posX = posX;
		this.posY = posY;
		this.damage = damage;
	}
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.shootSniperAttack(posX - 1, posY - 1, damage);		// Because human starts at 1 and pos at 0
		return false;
	}
	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command sniper = null;
		
		if (commandWords.length > 0 && matchCommandName(commandWords[0])){
			// The command starts by "sniper"
			if (commandWords.length == 4) {
				try {
					int currPosX = Integer.parseInt(commandWords[1]);
					int currPosY = Integer.parseInt(commandWords[2]);
					int currDamage = Integer.parseInt(commandWords[3]);
					
					if ((currPosX >= 1 && currPosX <= Game.COLUMNS) && (currPosY > 0 && currPosY <= Game.ROWS)) { 
						if (currDamage > 0) {
							// Everything correct
							sniper = new SniperCommand(currPosX, currPosY, currDamage);							
							
						} else {
							// damage not positive
							throw new CommandParseException(CommandParseException.WRONGFORMATOFARGS 
															+ ". " + ERRORDAMAGE);
						}						
					}
					else {
						// positions out of board
						throw new CommandParseException(CommandParseException.WRONGFORMATOFARGS 
														+ ". " + ERRORPOSITION);
					}
					
				}
				catch (NumberFormatException nfe){
					// not int values
					throw new CommandParseException(CommandParseException.WRONGFORMATOFARGS 
														+ ". " + CORRECTFORMAT);
				}			
				
				
			}
			else {
				// Wrong num of parameters
				throw new CommandParseException(CommandParseException.WRONGNUMOFARGS 
												+ ". " + CORRECTFORMAT);
			}
		}
		
		
		return sniper;
	}
}

package tp.p1.model.commands;

import tp.p1.model.Game;
import tp.p1.model.exceptions.CommandParseException;
import tp.p1.model.exceptions.commandExecuteExceptions.*;

public class ShootCommand extends Command {
	
	public static final String CORRECT_FORMAT = "Usage: shoot (supermissile)";
	public static final String EXISTS_ALREADY = "Cannot fire missile: missile already exists on board";
	
	private String Missile;
	
	public ShootCommand() {
		super("shoot", "s", "Shoot", "causes the UCM-Ship to launch a missile");
		// TODO Auto-generated constructor stub
	}
	
	public ShootCommand(String Missile) {
		super("shoot", "s", "Shoot", "causes the UCM-Ship to launch a missile");
		// TODO Auto-generated constructor stub
		this.Missile = Missile;
	}
	

	@Override
	public boolean execute(Game game) throws CommandExecuteException{		
		try {
			if(this.Missile == "Supermissile") {
				game.shootSuperMissile();
			}		
			
			else if(this.Missile == "Megamissile") {
				game.shootMegaMissile();
			}		
			else {
				game.shootMissile();
			}
		}
		catch (SuperMissileNotBoughtException | MissileAlreadyOnBoardException e) {
			throw new CommandExecuteException("Cannot fire missile: " + e.getMessage());
		}		
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command shoot = null;
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length == 1) {
				shoot = new ShootCommand(" ");
			}		
			else if (commandWords.length == 2) {
				if(commandWords[1].equalsIgnoreCase("supermissile")) {
					shoot = new ShootCommand("Supermissile");
				}
				
				else if(commandWords[1].equalsIgnoreCase("megamissile")) {
					shoot = new ShootCommand("Megamissile");
				}
				
				else {
					throw new CommandParseException(CommandParseException.WRONGFORMATOFARGS
							+ ". " + CORRECT_FORMAT);
				}
			}
			else {
				throw new CommandParseException(CommandParseException.WRONGNUMOFARGS
						+ ". " + CORRECT_FORMAT);
			}
		}
		
		return shoot;
	}

}

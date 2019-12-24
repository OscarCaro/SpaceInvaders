package tp.p1.model.commands;


import tp.p1.model.Game;
import tp.p1.model.exceptions.CommandParseException;
import tp.p1.model.exceptions.commandExecuteExceptions.CommandExecuteException;

public class BuyCommand extends Command{
	public static final String CORRECT_FORMAT = "Usage: buy (missile type)";

	private String missile;
	
	public BuyCommand() {
		super("buy", "b", "Buy", "Purchase a new supermissile");
	}
	
	public BuyCommand(String missile) {
		super("buy", "b", "Buy", "Purchase a new supermissile");
		this.missile = missile;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		if(this.missile == "supermissile") {
			game.buySuperMissile();
		}
		
		else if(this.missile == "megamissile") {
			game.buyMegaMissile();
		}
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command buy = null;
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length == 1) {
				buy = new BuyCommand("supermissile");
			}		
			else if (commandWords.length == 2) {
				if(commandWords[1].equalsIgnoreCase("supermissile")) {
					buy = new BuyCommand("supermissile");
				}
				
				else if(commandWords[1].equalsIgnoreCase("megamissile")) {
					buy = new BuyCommand("megamissile");
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
		
		return buy;
	}
}

package tp.p1.model.commands;

import tp.p1.model.Game;
import tp.p1.model.exceptions.CommandParseException;
import tp.p1.model.exceptions.commandExecuteExceptions.CommandExecuteException;

public class BuyCommand extends Command{
	private boolean isMega;
	public final String CORRECT_FORMAT_BUY = "Usage: buy (megamissile)";
	public BuyCommand() {
		super("buy", "b", "Buy", "Purchase a new supermissile");
	}
	
	public BuyCommand(boolean isMega) {
		super("buy", "b", "Buy", "Purchase a new supermissile");
		this.isMega = isMega;
	}
	
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		if(!isMega) {
			game.buySuperMissile();
		}
		else {
			game.buyMegaMissile();
		}
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command buy = null;
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length == 1) {
				buy = new BuyCommand(false);
			}
			else if (commandWords.length == 2)  {
				if(commandWords[1].equalsIgnoreCase("megamissile")) {
					buy = new BuyCommand(true);
				}
				else {
					throw new CommandParseException(CommandParseException.WRONGFORMATOFARGS
							+ ". " + CORRECT_FORMAT_BUY);
				}
			}
		}
	
		return buy;
	
	}
}


package tp.p1.model.commands;

import tp.p1.model.Game;
import tp.p1.model.exceptions.commandExecuteExceptions.CommandExecuteException;
import tp.p1.model.exceptions.commandExecuteExceptions.ScoreBuySupermissileException;

public class BuyCommand extends NoParamsCommand{

	public BuyCommand() {
		super("buy", "b", "Buy", "Purchase a new supermissile");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		game.buySuperMissile();
		return false;
	}
}

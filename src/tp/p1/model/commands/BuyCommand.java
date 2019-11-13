package tp.p1.model.commands;

import tp.p1.model.Game;

public class BuyCommand extends NoParamsCommand{

	public BuyCommand() {
		super("buy", "b", "Buy", "Purchase a new supermissile");
	}

	@Override
	public boolean execute(Game game) {
		if(!game.buySuperMissile()) {
			System.out.println("Not enough score to buy this weapon!");
		}
		return false;
	}
}

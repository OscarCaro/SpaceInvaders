package tp.p1.model.commands;

import tp.p1.model.Command;
import tp.p1.model.Game;

public class ShootCommand extends Command {

	public ShootCommand(String name, String shortName, String commandText, String helpText) {
		super(name, shortName, commandText, helpText);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		return null;
	}

}

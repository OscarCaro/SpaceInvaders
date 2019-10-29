package tp.p1.model.commands;

import tp.p1.model.Game;

public class ShootCommand extends Command {

	public ShootCommand() {
		super("shoot", "s", "Shoot", "causes the UCM-Ship to launch a missile");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command shoot = null;
		if (commandWords.length == 1  &&  matchCommandName(commandWords[0])) {			
			shoot = new ShootCommand();			
		}
		return shoot;
	}

}

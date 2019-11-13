package tp.p1.model.commands;

import tp.p1.model.Game;

public class ShootCommand extends Command {
	private boolean isSuper;
	public ShootCommand() {
		super("shoot", "s", "Shoot", "causes the UCM-Ship to launch a missile");
		// TODO Auto-generated constructor stub
	}
	
	public ShootCommand(boolean isSuper) {
		super("shoot", "s", "Shoot", "causes the UCM-Ship to launch a missile");
		// TODO Auto-generated constructor stub
		this.isSuper = isSuper;
	}
	

	@Override
	public boolean execute(Game game) {
		boolean execute = false;
		
		if(this.isSuper && game.shootSuperMissile()) {
			execute = true;
		}
		
		else if(!this.isSuper && game.shootMissile()){
			execute = true;
		}			
		
		else {
			System.out.println("Error: A missile is already fired!");
		}
		
		return execute;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command shoot = null;
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length == 1) {
				shoot = new ShootCommand(false);
			}
		
			else {
				if(commandWords[1].equalsIgnoreCase("supermissile")) {
				shoot = new ShootCommand(true);
				}
			}
		}
		
		return shoot;
	}



}

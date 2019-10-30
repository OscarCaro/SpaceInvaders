package tp.p1.model.commands;

import tp.p1.model.Game;

public class ShootCommand extends NoParamsCommand {

	public ShootCommand() {
		super("shoot", "s", "Shoot", "causes the UCM-Ship to launch a missile");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		boolean execute;
		if (game.ucmShipIsCanShoot()) {
			game.shootUcmMissile();			
			// Set missile + isCanShoot false
			execute = true;
		}
		else {
			System.out.println("Error: A missile is already fired");
			execute = false;
		}			
		return execute;
	}



}

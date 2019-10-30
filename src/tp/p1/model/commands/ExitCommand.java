package tp.p1.model.commands;

import tp.p1.model.Game;

public class ExitCommand extends NoParamsCommand {

	public ExitCommand() {
		super("exit", "e", "Exit", "terminates the program");
	}

	@Override
	public boolean execute(Game game) {
		game.finishGame();
		System.out.println("Game over");
		System.out.println("Player exit");
		return false;
	}


}

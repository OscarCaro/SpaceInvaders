package tp.p1.view;

import tp.p1.model.Game;

public abstract class GamePrinter {
	protected Game game;
	
	public void setGame(Game game) {
		this.game = game;
	}
}

package tp.p1.view;

import tp.p1.model.Game;

public class Stringifier extends GamePrinter {
	public Stringifier() {
		
	}
	
	public String toString(Game game) {
		String result = game.stringify();
		
		return result;
	}
}

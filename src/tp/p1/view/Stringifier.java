package tp.p1.view;

import tp.p1.model.Game;

public class Stringifier extends GamePrinter {
	public Stringifier() {
		
	}
	
	public String toString() {
		String result = game.stringify();			// Game object stored in superClass GamePrinter
		
		return result;
	}
}

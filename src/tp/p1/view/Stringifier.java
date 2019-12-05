package tp.p1.view;

public class Stringifier extends GamePrinter {
	public Stringifier() {
		
	}
	
	public String toString() {
		String result = game.stringify();			// Game object stored in superClass GamePrinter
		
		return result;
	}
}

package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Shockwave extends Weapon {
	public Shockwave(Game game) {
		super(-1, -1, game);		// -1 to avoid errors with inherited checkPos method
	}

}

package tp.p1.model.gameElements;

import tp.p1.model.Game;

public abstract class Weapon extends GameElements {
	
	public Weapon (int posX, int posY, Game game, int shield, String initial) {
		super(posX, posY, game, shield, initial);
	}

}

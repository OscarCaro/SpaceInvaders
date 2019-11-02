package tp.p1.model.gameElements;

import tp.p1.model.Game;

public abstract class Ship extends GameElements {
	
	public Ship(int posX,int posY,Game game, int shield) {
		super(posX, posY, game, shield);
	}	
	
}

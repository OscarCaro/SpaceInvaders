package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Carrier extends AlienShip{
	
	public Carrier(int posX, int posY, Game game) {	
		super(posX, posY, game, 2, 5);
	}
	
	@Override
	public String toString() {
		return "-<" + this.getShield() + ">-";
	}

	@Override
	public void onDelete() {
		AlienShip.decrementAlienCounter();
		this.game.receivePoints(this.getPoints());
	}
	
	@Override
	public void computerAction() {
		if(IExecuteRandomActions.canTurnExplosive(game)) {
			
		}
	}

}

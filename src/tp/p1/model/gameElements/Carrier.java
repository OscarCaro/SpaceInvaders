package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Carrier extends AlienShip{
	
	private boolean turnExplosive;
	
	public Carrier(int posX, int posY, Game game) {	
		super(posX, posY, game, 2, 5);
		turnExplosive = false;
	}
	
	@Override
	public String toString() {
		return "-<" + this.getShield() + ">-";
	}	

	public boolean getTurnExplosive() {
		return turnExplosive;
	}

	public void setTurnExplosive(boolean turnExplosive) {
		this.turnExplosive = turnExplosive;
	}

	@Override
	public void onDelete() {
		
		AlienShip.decrementAlienCounter();
		if(!this.getTurnExplosive()) {
			this.game.receivePoints(this.getPoints());		//Provisional
		}
		
	}
	
	@Override
	public void computerAction() {
		if(IExecuteRandomActions.canTurnExplosive(game)) {
			setTurnExplosive(true);
			game.TurnExplosive(this);
		}
	}

}

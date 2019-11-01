package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Carrier extends AlienShip implements Printable{
	
	public Carrier(int posX, int posY, Game game) {	
		super(posX, posY, game, 2, 5);
	}
	
	public String toString() {
		return "-<" + this.getShield() + ">-";
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
}

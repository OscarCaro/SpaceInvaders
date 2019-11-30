package tp.p1.model.gameElements;

import tp.p1.model.Game;

public abstract class EnemyShip extends Ship {
	private int points;
	
	public EnemyShip(int posX, int posY, Game game, int shield, int points, String initial) {
		super(posX, posY, game, shield, initial);
		this.points = points;
	}	
	
	@Override
	public boolean receiveMissileAttack(int damage) {
		this.decrementShield(damage);		
		return true;
	}
	
	@Override
	public boolean receiveSuperMissileAttack(int damage) {
		this.decrementShield(damage);
		return true;
	}
	
	@Override
	public boolean receiveExplosiveShipAttack(int damage) {
		this.decrementShield(damage);
		return true;
	}
	
	public int getPoints() {
		return points;
	}
	
	public String stringify() {
		String result="";		
		result += super.stringify() +";"+ points;
		return result;
	}

}

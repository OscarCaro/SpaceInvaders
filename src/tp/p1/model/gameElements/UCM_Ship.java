package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class UCM_Ship extends Ship{
	
	private final String sprite = "/-^-\\";
	private boolean shock; 	
	private boolean canShoot;
	private int score;

	
	public UCM_Ship (Game game, int posX, int posY) {
		super(4, 7, game, 3);
		this.shock = true;
		this.canShoot = true;
		this.score = 0;
	}
	
	@Override
	public String toString() {
		return this.sprite;
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub		
		// finish game
	}

	@Override
	public void move() {
		// This method should be empty because ucmShip doesn't move on update 		
		// remember to add score when killing enemies
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.decrementShield(damage);
		return true;
	}
	
	public boolean moveFromCommand(int numCells, Direction dir) {
		this.specificMove(dir, numCells);
		
		// Correct possible overflows when exceeding the sides
		int posX = this.getPosX();
		
		if (posX == -1) {
			this.setPosX(Game.COLUMNS - 1);
		} 
		else if (posX == -2) {
			this.setPosX(Game.COLUMNS - 2);
		} 
		else if (posX == Game.COLUMNS) {
			this.setPosX(0);
		}
		else if (posX == Game.COLUMNS + 1) {
			this.setPosX(1);
		}
		
		return true;
	}
	
	public boolean isCanShoot() {
		return canShoot;
	}

	public void setCanShoot(boolean canShoot) {
		this.canShoot = canShoot;
	}
	
	public boolean isShock() {
		return shock;
	}
	
	public void setShock(boolean shock) {
		this.shock = shock;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void addScore (int points) {
		this.score += points;
	}
}

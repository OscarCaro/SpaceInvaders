package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public class UCM_Ship extends Ship{
	
	private final String sprite = "/-^-\\";
	private boolean shock; 	
	private boolean canShoot;
	private int score;
	private int availableSupermissiles;

	
	public UCM_Ship (Game game, int posX, int posY) {
		super(4, 7, game, 3, "P");
		this.shock = false;
		this.canShoot = true;
		this.score = 0;
		this.availableSupermissiles = 0;
	}
	
	@Override
	public String toString() {
		return this.sprite;
	}

	@Override
	public void onDelete() {
		//Never called, UCM_Ship is never destroyed
	}

	@Override
	public void move() {
		// This method should be empty because ucmShip doesn't move on update 	
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
	
	public String stringify() {
		String result="";		
		result += super.stringify() +";"+ score +";"+ shock +";"+ availableSupermissiles;
		return result;
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
	
	public void substractScore (int points) {
		this.score -= points;
	}

	public int getAvailableSupermissiles() {
		return availableSupermissiles;
	}
	
	public void decrementSupermissiles() {
		this.availableSupermissiles -= 1;
	}
	
	public void incrementSupermissiles() {
		this.availableSupermissiles += 1;
	}

}

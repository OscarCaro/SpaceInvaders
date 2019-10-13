package tp.p1;

public class Game {
	
	private int cycleCounter;
	private int score;
	private int randomValue;
	private Board board;			// Contains list for bombs, carriers and destroyers
	private GamePrinter gamePrinter;
	
	

	public Game (Level diffLevel, int randomValue) {
		// Class constructor
		this.cycleCounter = 0;
		this.score = 0;
		this.randomValue = randomValue;
		this.board = new Board(diffLevel);	
		this.gamePrinter = new GamePrinter(Board.ROWS, Board.COLUMNS);
	}
	
	public void update() {
		// call each object's update methods
	}
	
	public void moveCarrierList() {
		if (this.board.carrierListIsMovingLeft()) {
			if (this.board.minDistToLeftSide() > 0) {
				// shift all carriers to left
				this.board.moveCarrierListLeft();
			}
			else {
				this.board.carrierListSetMovingRight(true);
				// shift all carriers one line down
				this.board.moveCarrierListDown();
			}
		}
		else {
			if (this.board.minDistToRightSide() > 0) {
				// shift all carriers to right
				this.board.moveCarrierListRight();
			}
			else {
				this.board.carrierListSetMovingLeft(true);
				// shift all carriers one line down
				this.board.moveCarrierListDown();
			}
		}
	}
	
	public void moveUcmShip(boolean left, boolean right, int numOfCells) {
		this.board.moveUcmShip(left, right, numOfCells);
	}
	
	public int getCycleCounter() {
		return cycleCounter;
	}

	public int getScore() {
		return score;
	}
	
	public int getUcmShipShield() {
		return this.board.getUcmShipShield();
	}
	
	public boolean getUcmShipIsShock() {
		return this.board.getUcmShipIsShock();
	}
	
	public int getNumOfAliens() {
		return this.board.getNumOfCarriers() + this.board.getNumOfDestroyers();
	}
	
	public String toString () {
		return gamePrinter.toString(this);
	}
	
	public String checkPos(int x, int y) {
		return board.checkCarrierListPos(x, y) 
				+ board.checkDestroyerListPos(x, y)
				+ board.checkUcmShip(x, y);
	}

}

package tp.p1;

import java.util.Random;

public class Game {
	
	private int cycleCounter;
	private int score;
	private Random random;
	private Board board;			// Contains list for bombs, carriers and destroyers
	private GamePrinter gamePrinter;
	private Level diffLevel;
	
	

	public Game (Level diffLevel, Random random) {
		// Class constructor
		this.cycleCounter = 0;
		this.score = 0;
		this.random = random;
		this.board = new Board(diffLevel);	
		this.gamePrinter = new GamePrinter(Board.ROWS, Board.COLUMNS);
		this.diffLevel = diffLevel;
	}
	
	public void update() {
		// call each object's update methods
		
		// Check if in this turn the ships should be moved
		if (checkTurnToMoveShips()) {
			this.moveCarrListAndDestList();
		}		
		// Check for colitions!!!
		
	}	
	
	public void computerAction() {
		Destroyer currentDest;
		
		// 1. Check if any destroyer is going to shoot
		for (int i = 0; i < this.board.getDestroyerListNumOfDestroyers(); i++) {
			currentDest = this.board.getDestroyer(i);
			if (currentDest.isCanShoot() && determineByProb(this.diffLevel.getFireFreq())) {
				// shoot
				this.board.newBomb(currentDest.getPosX(), currentDest.getPosY(), currentDest);
			}
			
		}
	}
	
	public boolean determineByProb(int max) {
		boolean goOn = false;
		if (random.nextInt(max - 1) == 1) {
			goOn = true;
		}
		return goOn;
	}
	
	public void moveCarrListAndDestList () {
		if (this.board.carrierListIsMovingLeft() && this.board.destroyerListIsMovingLeft()) {
			if (this.board.carrMinDistToLeftSide() > 0 && this.board.destMinDistToLeftSide() > 0) {
				// shift all carriers and destroyers to left
				this.board.moveCarrierListLeft();
				this.board.moveDestroyerListLeft();
			}
			else {
				this.board.carrierListSetMovingRight(true);
				this.board.destroyerListSetMovingRight(true);
				// shift all carriers and destroyers one line down
				this.board.moveCarrierListDown();
				this.board.moveDestroyerListDown();
			}
		}
		else {
			if (this.board.carrMinDistToRightSide() > 0 && this.board.destMinDistToRightSide() > 0) {
				// shift all carriers to right
				this.board.moveCarrierListRight();
				this.board.moveDestroyerListRight();
			}
			else {
				this.board.carrierListSetMovingLeft(true);
				this.board.destroyerListSetMovingLeft(true);
				// shift all carriers and destroyers one line down
				this.board.moveCarrierListDown();
				this.board.moveDestroyerListDown();
			}
		}
	}	
	
	private boolean checkTurnToMoveShips() {
		boolean move = false;
		if (this.diffLevel == Level.EASY && this.cycleCounter % 3 == 0) {
			move = true;
		}
		else if (this.diffLevel == Level.HARD && this.cycleCounter % 2 == 0) {
			move = true;
		}
		else if (this.diffLevel == Level.INSANE) {
			move = true;
		}
		return move;
	}
	
	public void moveUcmShip(boolean left, boolean right, int numOfCells) {
		this.board.moveUcmShip(left, right, numOfCells);
	}
	
	public int getCycleCounter() {
		return cycleCounter;
	}

	public void setCycleCounter(int cycleCounter) {
		this.cycleCounter = cycleCounter;
	}
	
	public void incrementCycleCounter() {
		this.cycleCounter++;
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

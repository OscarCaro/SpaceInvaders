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
		
		
		// 1. Check if in this turn the ships should be moved -> move them
		if (checkTurnToMoveShips()) {
			this.moveCarrListAndDestList();
		}	
		// 1.1 Move Ufo	
		// 1.2 Check out of board
		if (this.board.ufoExists()) {
			this.board.moveUfo();
		}
		
		// 2.1 move bombs down
		// 2.2 check for out of board
		// 2.3 check for collitions 		
		this.board.moveDownBombs();
		
		// 3.1 Move missile
		// 3.2 check out of board
		// 3.3 check for collitions	
		if(this.board.missileExists()) {
			this.board.launchMissile();
		}
		
		// 4 Check for dead enemies (Shield == 0)
		this.checkDeadEnemies();
		
	}		
	
	public void computerAction() {
		Destroyer currentDest;
		
		// 1. Check if any destroyer is going to shoot
		for (int i = 0; i < this.board.getDestroyerListNumOfValidDestroyers(); i++) {
			currentDest = this.board.getDestroyer(i);
			if (currentDest.isCanShoot() && determineByProb(this.diffLevel.getFireFreq())) {
				// shoot + canShoot = false (done in bomb constructor)
				this.board.newBomb(currentDest.getPosX(), currentDest.getPosY(), currentDest);
			}
			
		}
		
		// 2. Spawn ufo if there's none and prob
		if (!this.board.ufoExists() && determineByProb(this.diffLevel.getUfoFreq())) {
			this.board.createUfo();
		}
		
	}
	
	public String checkPos(int x, int y) {
		return board.checkCarrierListPos(x, y) 
				+ board.checkDestroyerListPos(x, y)
				+ board.checkUcmShip(x, y)
				+ board.checkBombListPos(x, y)
				+ board.checkUcmMissile(x, y)
				+ board.checkUfo(x, y);				
	}	
	
	public boolean determineByProb(int max) {
		boolean goOn = false;
		if (random.nextInt(max) == 1) {
			goOn = true;
		}
		return goOn;
	}
	
	public boolean checkEnemiesInBottomRow() {
		boolean thereIs = false;
		if (this.board.checkCarriersInBottomRow() || this.board.checkDestroyersInBottomRow()) {
			thereIs = true;
		}

		return thereIs;
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
	
	public void checkDeadEnemies() {
		checkDestroyersDead();
		checkCarriersDead();
		checkUFOdead();
	}
	
	public boolean checkUCMdead() {
		return (this.board.getUcmShipShield() <= 0);		
	}
	
	public void checkUFOdead() {
		if(this.board.ufoExists() && this.board.getUFOShield() <= 0) {
			this.score += this.board.getUFOPoints();
		}
	}
	
	public void checkDestroyersDead() {
		for (int i = 0; i < this.board.getDestroyerListNumOfValidDestroyers(); i++) {
			if(this.board.getDestroyerShield(i) <= 0) {
				//Add destroyer score and then kill destroyer/remove it
				this.score += this.board.getDestroyerScore(i);
				this.board.destroyerListDeleteDestroyer(this.board.getDestroyerListPosX(i), this.board.getDestroyerListPosY(i));
			}
		}
	}
	
	public void checkCarriersDead() {
		for (int i = 0; i < this.board.getCarrierListNumOfValidCarriers(); i++) {
			if(this.board.getCarrierShield(i) <= 0) {
				//kill carrier and remove it
				this.score += this.board.getCarrierScore(i);
				this.board.carrierListDeleteCarrier(this.board.getCarrierListPosX(i), this.board.getCarrierListPosY(i));
			}
		}
	}
	
	public boolean useShockwave() {
		boolean okay = false;
		
		if (this.board.ucmHasShockwave()) {
			this.board.useShockwave();
		}
		return okay;
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
	
	public String toString () {
		return gamePrinter.toString(this);
	}
	
// <<<<<<<<<<  Delegate methods to: CARRIERLIST + DESTROYERLIST  >>>>>>>>>>>

	public int getNumOfValidAliens() {
		return this.board.getCarrierListNumOfValidCarriers() + this.board.getDestroyerListNumOfValidDestroyers();
	}	
	
// <<<<<<<<<<  Delegate methods to: UCM_SHIP  >>>>>>>>>>>
	
	public boolean ucmShipIsCanShoot() {
		return board.ucmShipIsCanShoot();
	}
	
	public boolean getUcmShipIsShock() {
		return this.board.getUcmShipIsShock();
	}
	
	public int getUcmShipShield() {
		return this.board.getUcmShipShield();
	}
	
	public void moveUcmShip(boolean left, boolean right, int numOfCells) {
		this.board.moveUcmShip(left, right, numOfCells);
	}
	
// <<<<<<<<<<  Delegate methods to: UCM_MISSILE  >>>>>>>>>>>
	
	public void shootUcmMissile() {
		this.board.shootUcmMissile();
	}
	
// <<<<<<<<<<  GETTERS & SETTERS  >>>>>>>>>>>
	
	public int getScore() {
		return score;
	}
	
	public int getCycleCounter() {
		return cycleCounter;
	}
	
	public void incrementCycleCounter() {
		this.cycleCounter++;
	}

}

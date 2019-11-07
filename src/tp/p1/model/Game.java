package tp.p1.model;

import java.util.Random;

import tp.p1.model.gameElements.AlienShip;
import tp.p1.model.gameElements.Bomb;
import tp.p1.model.gameElements.Destroyer;
import tp.p1.model.gameElements.GameElements;
import tp.p1.model.gameElements.IExecuteRandomActions;
import tp.p1.model.gameElements.IPlayerController;
import tp.p1.model.gameElements.Shockwave;
import tp.p1.model.gameElements.UCM_Missile;
import tp.p1.model.gameElements.UCM_Ship;
import tp.p1.view.GamePrinter;

public class Game implements IPlayerController, IExecuteRandomActions{
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 9;
	
	private Board board; 					// Private??
	private UCM_Ship player;
	private BoardInitializer initializer; 
	private GamePrinter gamePrinter;

	private Random rand;
	private Level diffLevel;	
	private int currentCycle;
	private boolean doExit;
	
	public Game (Level gameLevel, Random random){
		rand = random;
		diffLevel = gameLevel;
		gamePrinter = new GamePrinter(Game.ROWS, Game.COLUMNS);
		initializer = new BoardInitializer();
		initGame();
	}
	
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize (this, diffLevel);
		player = new UCM_Ship(this, COLUMNS / 2, ROWS - 1);
		board.add(player);
	}
	
	public Random getRandom() {
		return rand;
	}
	
	public Level getDiffLevel() {
		return diffLevel;
	}
	
	public void reset() {
		initGame();
		doExit = false;
	}
	
	public void addObject(GameElements object) {
		board.add(object);
	}
	
	public String posToString(int x, int y) {
		return board.posToString(x, y);			// called toString in statement
	}
	
	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	
	public boolean aliensWin() {
		
		return !player.isAlive () ||  AlienShip.haveLanded();
	}
	
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}
	
	public boolean isOnBoard (int x, int y) {
		return (x >= 0 && x < COLUMNS) && (y >= 0 && y < ROWS);
	}
	
	public String infoToString() {
		String str = "";
		
		str += "Score: " + this.player.getScore() + System.lineSeparator();
		str += "Shield Strength: " + this.player.getShield() + System.lineSeparator();
		String hasShock; 
		if (this.player.isShock()) {
			hasShock = "Yes";
		} else {
			hasShock = "No";
		}
		str += "Shockwave: " + hasShock + System.lineSeparator();
		str += "Cycle number: " + this.currentCycle + System.lineSeparator();
		str += "Remaining alien ships: " + AlienShip.getCounter() + System.lineSeparator();
		
		return str;
	}
	
	public String getWinnerMessage () {
		if(playerWin()) {
			return "Player win!";}
		else if(aliensWin()) {
			return "Aliens win!";
		}
		else if(doExit) {
			return "Player exits the game";
		}
		else {
			return "This should not happen";
		}
	}

	private boolean playerWin() {
		boolean win = false;
		//1) Implement function for checking dead enemies
		//2) Implement function for checking enemies in bottom row
		//3) Condition player alive
		if(AlienShip.allDead() && !aliensWin()) {
			win = true;
		}
		return win;
	}

	@Override
	public boolean movePlayer (int numCells, Direction dir) {
		return this.player.moveFromCommand(numCells, dir);
	}

	@Override
	public boolean shootMissile() {
		// TODO Auto-generateshd method stubshoo
		return false;
	}

	@Override
	public boolean useShockWave() {
		boolean attack = false;
		if (player.isShock()) {
			board.useShockwaveFromCommand(new Shockwave(this));
			player.setShock(false);
			attack = true;
		}
		return attack;
	}

	@Override
	public void receivePoints(int points) {
		this.player.addScore(points);
	}

	@Override
	public void enableShockWave() {
		this.player.setShock(true);
	}

	@Override
	public void enableMissile() {
		this.player.setCanShoot(true);
	}

	public void finishGame() {
		doExit = true;		
	}
	
	public String toString () {
		return gamePrinter.toString(this);
	}
	
	
	
//	
//	private int cycleCounter;
//	private int score;
//	private Random random;
//	private Board board;			// Contains list for bombs, carriers and destroyers
//	private GamePrinter gamePrinter;
//	private Level diffLevel;	
//	private boolean continueGame;
//	
//
//	public Game (Level diffLevel, Random random) {
//		// Class constructor
//		this.cycleCounter = 0;
//		this.score = 0;
//		this.random = random;
//		this.board = new Board(diffLevel);	
//		this.gamePrinter = new GamePrinter(Board.ROWS, Board.COLUMNS);
//		this.diffLevel = diffLevel;
//		this.continueGame = true;
//	}
//	
//	public void update() {
//		
//		
//		// 1. Check if in this turn the ships should be moved -> move them
//		if (checkTurnToMoveShips()) {
//			this.moveCarrListAndDestList();
//		}	
//		// 1.1 Move Ufo	
//		// 1.2 Check out of board
//		if (this.board.ufoExists()) {
//			this.board.moveUfo();
//		}
//		
//		// 2.1 move bombs down
//		// 2.2 check for out of board
//		// 2.3 check for collitions 		
//		this.board.moveDownBombs();
//		
//		// 3.1 Move missile
//		// 3.2 check out of board
//		// 3.3 check for collitions	
//		if(this.board.missileExists()) {
//			this.board.launchMissile();
//		}
//		
//		// 4 Check for dead enemies (Shield == 0)
//		this.checkDeadEnemies();
//		
//	}		
//	
//	public void computerAction() {
//		Destroyer currentDest;
//		
//		// 1. Check if any destroyer is going to shoot
//		for (int i = 0; i < this.board.getDestroyerListNumOfValidDestroyers(); i++) {
//			currentDest = this.board.destroyerListGetDestroyer(i);
//			if (currentDest.isCanShoot() && determineByProb(this.diffLevel.getFireFreq())) {
//				// shoot + canShoot = false (done in bomb constructor)
//				this.board.newBomb(currentDest.getPosX(), currentDest.getPosY(), currentDest);
//			}
//			
//		}
//		
//		// 2. Spawn ufo if there's none and prob
//		if (!this.board.ufoExists() && determineByProb(this.diffLevel.getUfoFreq())) {
//			this.board.createUfo();
//		}
//		
//	}
//	
//	public String checkPos(int x, int y) {
//		return board.checkCarrierListPos(x, y) 
//				+ board.checkDestroyerListPos(x, y)
//				+ board.checkUcmShip(x, y)
//				+ board.checkBombListPos(x, y)
//				+ board.checkUcmMissile(x, y)
//				+ board.checkUfo(x, y);				
//	}	
//	
//	public boolean determineByProb(int max) {
//		boolean goOn = false;
//		if (random.nextInt(max) == 1) {
//			goOn = true;
//		}
//		return goOn;
//	}
//	
//	public boolean checkEnemiesInBottomRow() {
//		boolean thereIs = false;
//		if (this.board.checkCarriersInBottomRow() || this.board.checkDestroyersInBottomRow()) {
//			thereIs = true;
//		}
//
//		return thereIs;
//	}
//	
//	public void moveCarrListAndDestList () {
//		if (this.board.carrierListIsMovingLeft() && this.board.destroyerListIsMovingLeft()) {
//			if (this.board.carrierListMinDistToLeftSide() > 0 && this.board.destroyerListMinDistToLeftSide() > 0) {
//				// shift all carriers and destroyers to left
//				this.board.moveCarrierListLeft();
//				this.board.moveDestroyerListLeft();
//			}
//			else {
//				this.board.carrierListSetMovingRight(true);
//				this.board.destroyerListSetMovingRight(true);
//				// shift all carriers and destroyers one line down
//				this.board.moveCarrierListDown();
//				this.board.moveDestroyerListDown();
//			}
//		}
//		else {
//			if (this.board.carrierListMinDistToRightSide() > 0 && this.board.destroyerListMinDistToRightSide() > 0) {
//				// shift all carriers to right
//				this.board.moveCarrierListRight();
//				this.board.moveDestroyerListRight();
//			}
//			else {
//				this.board.carrierListSetMovingLeft(true);
//				this.board.destroyerListSetMovingLeft(true);
//				// shift all carriers and destroyers one line down
//				this.board.moveCarrierListDown();
//				this.board.moveDestroyerListDown();
//			}
//		}
//	}	
//	
//	public void checkDeadEnemies() {
//		checkDestroyersDead();
//		checkCarriersDead();
//		checkUFOdead();
//	}
//	
//	public boolean checkUCMdead() {
//		return (this.board.getUcmShipShield() <= 0);		
//	}
//	
//	public void checkUFOdead() {
//		if(this.board.ufoExists() && this.board.getUFOShield() <= 0) {
//			this.score += this.board.getUFOPoints();
//		}
//	}
//	
//	public void checkDestroyersDead() {
//		for (int i = 0; i < this.board.getDestroyerListNumOfValidDestroyers(); i++) {
//			if(this.board.destroyerListGetDestroyerShield(i) <= 0) {
//				//Add destroyer score and then kill destroyer/remove it
//				this.score += this.board.destroyerListGetDestroyerScore(i);
//				this.board.destroyerListDeleteDestroyer(this.board.destroyerListGetDestroyerPosX(i), this.board.destroyerListGetDestroyerPosY(i));
//			}
//		}
//	}
//	
//	public void checkCarriersDead() {
//		for (int i = 0; i < this.board.getCarrierListNumOfValidCarriers(); i++) {
//			if(this.board.carrierListgetCarrierShield(i) <= 0) {
//				//kill carrier and remove it
//				this.score += this.board.carrierListgetCarrierScore(i);
//				this.board.carrierListDeleteCarrier(this.board.carrierListGetCarrierPosX(i), this.board.carrierListGetCarrierPosY(i));
//			}
//		}
//	}
//	
//	public boolean useShockwave() {
//		boolean okay = false;
//		
//		if (this.board.ucmHasShockwave()) {
//			this.board.useShockwave();
//		}
//		return okay;
//	}
//	
//	private boolean checkTurnToMoveShips() {
//		boolean move = false;
//		if (this.diffLevel == Level.EASY && this.cycleCounter % 3 == 0) {
//			move = true;
//		}
//		else if (this.diffLevel == Level.HARD && this.cycleCounter % 2 == 0) {
//			move = true;
//		}
//		else if (this.diffLevel == Level.INSANE) {
//			move = true;
//		}
//		return move;
//	}	
//	
//	public String toString () {
//		return gamePrinter.toString(this);
//	}
//	
//	
//	
//// <<<<<<<<<<  Delegate methods to: CARRIERLIST + DESTROYERLIST  >>>>>>>>>>>
//
//	public int getNumOfValidAliens() {
//		return this.board.getCarrierListNumOfValidCarriers() + this.board.getDestroyerListNumOfValidDestroyers();
//	}	
//	
//// <<<<<<<<<<  Delegate methods to: UCM_SHIP  >>>>>>>>>>>
//	
//	public boolean ucmShipIsCanShoot() {
//		return board.ucmShipIsCanShoot();
//	}
//	
//	public boolean getUcmShipIsShock() {
//		return this.board.getUcmShipIsShock();
//	}
//	
//	public int getUcmShipShield() {
//		return this.board.getUcmShipShield();
//	}
//	
//	public void moveUcmShip(boolean left, boolean right, int numOfCells) {
//		this.board.moveUcmShip(left, right, numOfCells);
//	}
//	
//
//	
//// <<<<<<<<<<  Delegate methods to: UCM_MISSILE  >>>>>>>>>>>
//	
//	public void shootUcmMissile() {
//		this.board.shootUcmMissile();
//	}
//	
//// <<<<<<<<<<  GETTERS & SETTERS  >>>>>>>>>>>
//	
//	public int getScore() {
//		return score;
//	}
//	
//	public int getCycleCounter() {
//		return cycleCounter;
//	}
//	
//	public void incrementCycleCounter() {
//		this.cycleCounter++;
//	}
//	
//	public boolean isFinished() {
//		
//		if(checkEnemiesInBottomRow() || checkUCMdead()) {
//			continueGame = false;
//			System.out.println("Game Over, Aliens win");
//		}
//		
//		if(getNumOfValidAliens() == 0) {
//			continueGame = false;
//			System.out.println("You win!!!");
//		}
//		return !this.continueGame;
//	}
//	
//	public void finishGame() {
//		this.continueGame = false;
//	}
//
//
	}

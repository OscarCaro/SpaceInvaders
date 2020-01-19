package tp.p1.model;

import java.util.Random;

import tp.p1.model.exceptions.commandExecuteExceptions.*;
import tp.p1.model.gameElements.*; 


public class Game implements IPlayerController, IExecuteRandomActions{
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 9;
	
	private Board board; 
	private UCM_Ship player;
	private BoardInitializer initializer; 


	private Random rand;
	private Level diffLevel;	
	private int currentCycle;
	private boolean doExit;
	
	public Game (Level gameLevel, Random random){
		rand = random;
		diffLevel = gameLevel;
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
		return board.posToString(x, y);	
	}
	
	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	
	public boolean aliensWin() {		
		return !player.isAlive () ||  AlienShip.haveLanded();
	}
	
	public void update() {		
		if (!Ufo.exists() && IExecuteRandomActions.canGenerateUfo(this)) {
			this.board.add(new Ufo(this));
		}
		
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
		str += "Available supermissiles: " + this.player.getAvailableSupermissiles() + System.lineSeparator();
		str += "Cycle number: " + this.currentCycle + System.lineSeparator();
		str += "Remaining alien ships: " + AlienShip.getAlienCounter() + System.lineSeparator();
		
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
	public void movePlayer (int numCells, Direction dir) {
		this.player.moveFromCommand(numCells, dir);
	}

	@Override
	public void shootMissile() throws MissileAlreadyOnBoardException {		
		if (player.isCanShoot()) {
			this.addObject( new UCM_Missile(player.getPosX(), player.getPosY(), this) );
			player.setCanShoot(false);
		}
		else {
			throw new MissileAlreadyOnBoardException();
		}
	}
	
	
	private boolean spendPoints(int points) {
		boolean ok = false;
		if(this.player.getScore() >= points) {
			this.player.substractScore(points);
			ok = true;
		}
		
		return ok;
	}
	
	@Override
	public void buySuperMissile() throws ScoreBuySupermissileException {		
		if(this.spendPoints(Supermissile.COST)) {
			this.player.incrementSupermissiles();
		}
		else {
			throw new ScoreBuySupermissileException();
		}
	}
	
	@Override
	public void shootSuperMissile() throws SuperMissileNotBoughtException, MissileAlreadyOnBoardException{		
		if (player.isCanShoot()) {
			if (player.getAvailableSupermissiles() > 0){
				this.addObject( new Supermissile(player.getPosX(), player.getPosY(), this) );
				this.player.decrementSupermissiles();
				player.setCanShoot(false);
			}			
			else {
				throw new SuperMissileNotBoughtException();
			}
		}		
		else {
			throw new MissileAlreadyOnBoardException();
		}
	}
	
	public void TurnExplosive( GameElements element) {
		this.board.remove(element);
		this.board.add(new ExplosiveShip(element.getPosX(), element.getPosY(), this, element.getShield()));
	}
	
	public void upgradeDest(GameElements element) {
		this.board.remove(element);
		this.board.add(new SuperDestroyer(element.getPosX(), element.getPosY(), this, element.getShield()));
	}
	
	public void explosiveShipDead(int posX, int posY) {
		// Calculate position of neighbor ships
		// Attack them
		this.board.performExplosiveShipAttack(posX - 1, posY - 1);
		this.board.performExplosiveShipAttack(posX, posY - 1);
		this.board.performExplosiveShipAttack(posX + 1, posY - 1);
		this.board.performExplosiveShipAttack(posX - 1, posY);
		this.board.performExplosiveShipAttack(posX + 1, posY);
		this.board.performExplosiveShipAttack(posX - 1 , posY + 1);
		this.board.performExplosiveShipAttack(posX, posY + 1);
		this.board.performExplosiveShipAttack(posX + 1, posY + 1);
	}

	@Override
	public void shockWave() throws NoShockwaveException {		
		if (player.isShock()) {
			this.addObject(new Shockwave(this));
			player.setShock(false);
		}
		else {
			throw new NoShockwaveException();
		}
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

	public String stringify() {
		String banner = "----Space Invaders v3---- \n \n";
		String cycle = "G"+ ";"+ currentCycle + "\n";
		String level = "L" + ";" + diffLevel + "\n";

		String result = banner + cycle + level + board.stringify();
		return result;
	}
}

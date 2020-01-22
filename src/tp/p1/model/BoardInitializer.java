package tp.p1.model;

import tp.p1.model.gameElements.*;

public class BoardInitializer {
	
	private Level level;
	private Board board;
	private Game game;	
	
	public Board initialize (Game game, Level level) {
		this.level  = level;
		this.game = game;
		board = new Board(Game.COLUMNS, Game.ROWS);
		
		AlienShip.resetAlienCounter();
		AlienShip.setMoveDirection(Direction.LEFT);
		AlienShip.setMoveDownInThisTurn(false);
		AlienShip.setMoveDownInNextTurn(false);
		AlienShip.setInBottomRow(false);
		
		Ufo.setExists(false);
		
		initializeCarrierShips();
		initializeDestroyers();
		initializeSmartBombs();
		//We decided not to create an UFO in the first turn
		return board;
	}
	
	private void initializeCarrierShips () {
		int numOfCarriers = this.level.getNumCarrierShips();
		
		if (this.level == Level.EASY) {
			createCarriersEasy(numOfCarriers);
		}
	
		else if (this.level == Level.HARD) {
			createCarriersHard(numOfCarriers);
		}
		
		else if (this.level == Level.INSANE) {
			createCarriersInsane(numOfCarriers);
		}
	}
	
	private void initializeDestroyers () {
		int numOfDestroyersPerRow = this.level.getNumDestroyersPerRow();
		
		if (this.level == Level.EASY) {
			createDestroyersEasy(numOfDestroyersPerRow);
		}
	
		else if (this.level == Level.HARD) {
			createDestroyersHard(numOfDestroyersPerRow);
		}
		
		else if (this.level == Level.INSANE) {
			createDestroyersInsane(numOfDestroyersPerRow);
		}
		
	}	
	
	private void initializeSmartBombs () {
		int numOfSmartBombs = this.level.getNumSmartBombs();
		
		if (this.level == Level.EASY) {
			createSmartBombsEasy(numOfSmartBombs);
		}
	
		else if (this.level == Level.HARD) {
			createSmartBombsHard(numOfSmartBombs);
		}
		
		else if (this.level == Level.INSANE) {
			createSmartBombsInsane(numOfSmartBombs);
		}
		
	}	
	
	public void createSmartBombsEasy(int numOfSmartBombs) {
		this.board.add(new SmartBomb(4, 0, game));
	}

	public void createSmartBombsHard(int numOfSmartBombs) {
		this.board.add(new SmartBomb(2, 0, game));
		this.board.add(new SmartBomb(6, 0, game));
	}
	
	public void createSmartBombsInsane(int numOfSmartBombs) {
		this.board.add(new SmartBomb(1, 0, game));
		this.board.add(new SmartBomb(4, 0, game));
		this.board.add(new SmartBomb(7, 0, game));

	}
	
	public void createDestroyersEasy(int initNumOfDestroyers) {
		int posX = 4;
		int posY = 2;
				
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			this.board.add(new Destroyer(posX, posY, game));
			posX++;
			
		}		
	}

	public void createDestroyersHard(int initNumOfDestroyers) {
		int posX = 3;
		int posY = 3;
				
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			this.board.add(new Destroyer(posX, posY, game));
			posX++;
		}
	}
	
	public void createDestroyersInsane(int initNumOfDestroyers) {
		int posX = 3;
		int posY = 4;
				
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			this.board.add(new Destroyer(posX, posY, game));
			posX++;
		}
	}

	
	
	public void createCarriersEasy(int initNumOfCarriers) {
		int posX = 3;
		int posY = 1;
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			this.board.add(new Carrier(posX,  posY, game));
			posX++;
		}
	}
	
	public void createCarriersHard(int initNumOfCarriers) {
		int posX = 3;
		int posY = 1;
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			if(i == 4) {
				posY++;
				posX = 3;
			}
			this.board.add(new Carrier(posX,  posY, game));
			posX++;
		}
	}
	
	public void createCarriersInsane(int initNumOfCarriers) {
		int posX = 3;
		int posY = 1;
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			if(i == 4|| i == 8) {
				posY++;
				posX = 3;
			}
			this.board.add(new Carrier(posX,  posY, game));
			posX++;
		}
	}
}

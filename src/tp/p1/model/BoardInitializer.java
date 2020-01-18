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
		initializeCommanders();
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
	
	private void initializeCommanders () {
		int numOfDestroyersPerRow = this.level.getNumCommanders();
		
		if (this.level == Level.INSANE) {
			createCommandersInsane(numOfDestroyersPerRow);
		}
		
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
	
	public void createCommandersInsane(int initNumOfCommanders) {
		int posX = 4;
		int posY = 5;
				
		for (int i = 0; i < initNumOfCommanders; i++ ) {
			this.board.add(new Commander(posX, posY, game));
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

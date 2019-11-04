package tp.p1.model;

import tp.p1.model.gameElements.AlienShip;
import tp.p1.model.gameElements.Carrier;
import tp.p1.model.gameElements.Destroyer;
import tp.p1.model.gameElements.GameElements;

public class BoardInitializer {
	
	private Level level;
	private Board board;
	private Game game;	
	
	public Board initialize (Game game, Level level) {
		this.level  = level;
		this.game = game;
		board = new Board(Game.COLUMNS, Game.ROWS);
		AlienShip.resetCounter();
		initializeUfo();
		initializeCarrierShips();
		initializeDestroyers();
		return board;
	}
	
	private void initializeUfo () {
		// TODO: add UFO is probability gives true 
	} 
	
	private void initializeCarrierShips () {
		int numOfRows = this.level.getNumRowsOfCarrierShips();
		int numOfCarriersPerRow = this.level.getNumCarrierShipsPerRow();
		
		int initRow = 1;
		int initCol = 3;
		
		for (int row = initRow; row < initRow + numOfRows; row++) {
			for (int col = initCol; col < initCol + numOfCarriersPerRow; col++) {
				this.board.add(new Carrier(col, row, this.game));
			}
		}
	}
	
	private void initializeDestroyers () {
		int numOfDestroyersPerRow = this.level.getNumDestroyersPerRow();
		
		int initRow = 3;
		if (this.level == Level.EASY) {
			initRow = 2;
		}
		
		int initCol = 4;
		if (this.level == Level.INSANE) {
			initCol = 3;
		}
		
		for (int i = 0; i < numOfDestroyersPerRow; i++) {
			this.board.add(new Destroyer(initCol + i, initRow, game));
		}
	}
}

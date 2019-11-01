package tp.p1.model;

import tp.p1.model.gameElements.GameElements;

public class BoardInitializer extends GameElements {
	
	public BoardInitializer() {
		super(posX, posY, game);
		// TODO Auto-generated constructor stub
	}
	private Level level;
	private Board board;
	private Game game;
	
	
	public Board initialize (Game game, Level level) {
		this.level  = level;
		this.game = game;
		board = new Board(Game.DIM_X, Game.DIM_Y);
		initializeUfo();
		initializeCarrierShips();
		initializeDestroyers();
		return board;
		}
	private void initializeUfo () {
		// TODO implement
		} 
	private void initializeCarrierShips () {
		// TODO implement
		}
		private void initializeDestroyers () {
			// TODO implement}
	}
}

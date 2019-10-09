package tp.p1;

public class Game {
	
	private int cycleCounter;
	private int score;
	private int randomValue;
	private Board board;			// Contains list for bombs, carriers and destroyers
	
	public Game (Level diffLevel, int randomValue) {
		// Class constructor
		this.cycleCounter = 0;
		this.score = 0;
		this.randomValue = randomValue;
		this.board = new Board(diffLevel);		
	}
	
	public void update() {
		// call each object's update methods
	}
	
	public String checkPos(int x, int y) {
		return board.checkCarrierListPos(x, y) + board.checkDestroyerListPos(x, y);
	}

}

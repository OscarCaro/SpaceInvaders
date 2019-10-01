package tp.p1;
import java.util.Random;

public class Game {
	
	private int cycleCounter;
	private int score;
	private Random randomValue;
	private Board board;			// Contains list for bombs, carriers and destroyers
	
	public Game (Level diffLevel, Random randomValue) {
		// Class constructor
		this.cycleCounter = 0;
		this.score = 0;
		this.randomValue = randomValue;
		this.board = new Board(diffLevel);		
	}
	
	public void update() {
		// call each object's update methods
	}

}

package tp.p1;
import java.util.Random;

public class Game {
	
	private int cycleCounter;
	private int score;
	private Random randomValue;
	private Board board;			// Contains list for bombs, carriers and destroyers
	
	public Game () {
		// Class constructor
		this.cycleCounter = 0;
		this.score = 0;
		this.randomValue = new Random();
		this.board = new Board();		
	}
	
	public void update() {
		// call each object's update methods
	}

}

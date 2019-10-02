package tp.p1;

import java.util.Random;

public class Main {
	
	private static Level diffLevel;
	private static Random randomSeed;


	public static void main(String[] args) {
		
		if (Arguments.processArgs(args)) {
			// Continue with program -- diffLevel and randomSeed are correctly set
			
			//GamePrinter printer = new GamePrinter(game, 8, 9);
			//System.out.println(printer);
			
		}
		else {
			// Stop program: wrong arguments have been passed
		}		
	}
	
	public static void setDiffLevel(Level level) {
		diffLevel = level;
	}
	
	public static void setRandomSeed(Random seed) {
		randomSeed = seed;
	}	

}

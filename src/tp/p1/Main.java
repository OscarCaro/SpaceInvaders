package tp.p1;

import java.util.Random;

public class Main {
	
	private static Level diffLevel;
	private static long seed;
	private static Controller controller;
	private static Random random;

	public static void main(String[] args) {
		
		if (Arguments.processArgs(args)) {
			// Continue with program -- diffLevel and randomSeed are correctly set
			
			random = new Random(seed);
			controller = new Controller(diffLevel, random);
			controller.run();
			
		}
		else {
			// Stop program: wrong arguments have been passed
			System.out.println ("Wrong arguments");
		}		
	}
	
	public static void setDiffLevel(Level level) {
		diffLevel = level;
	}
	
	public static void setRandomSeed(long seed) {
		Main.seed = seed;
	}	

}

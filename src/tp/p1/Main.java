package tp.p1;

import java.util.Random;

public class Main {
	
	private static Level diffLevel;
	private static long seed;
	private static int randomValue;
	private static Controller controller;

	public static void main(String[] args) {
		
		if (Arguments.processArgs(args)) {
			// Continue with program -- diffLevel and randomSeed are correctly set
			
			randomValue = new Random(seed).nextInt();
			controller = new Controller(diffLevel, randomValue);
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

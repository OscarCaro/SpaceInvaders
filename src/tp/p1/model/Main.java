/*	Space Invaders
 * 
 * 	Authors:	- Alberto Lopez Cervantes
 * 				- Oscar Caro Navarro
 */



package tp.p1.model;

import java.util.Random;

import tp.p1.controller.Controller;

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
			boolean playAgain = controller.run();
			
			while (playAgain) {		
				random = new Random(seed);
				controller = new Controller(diffLevel, random);
				playAgain = controller.run();
			}
			
		}
		else {
			// Stop program: wrong arguments have been passed
			System.out.println ("Wrong arguments" + System.lineSeparator());
		}		
	}
	
	public static void setDiffLevel(Level level) {
		diffLevel = level;
	}
	
	public static void setRandomSeed(long seed) {
		Main.seed = seed;
	}	

}

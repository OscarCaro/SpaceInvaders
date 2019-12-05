/*	Space Invaders
 * 
 * 	Authors:	- Alberto Lopez Cervantes
 * 				- Oscar Caro Navarro
 */

package tp.p1.model;

import java.util.Random;

import tp.p1.controller.Controller;
import tp.p1.model.exceptions.WrongArgumentsException;

public class Main {
	
	private static Level diffLevel;
	private static long seed;
	private static Controller controller;
	private static Random random;

	public static void main(String[] args) {
		
		try {
			Arguments.processArgs(args);
				
			random = new Random(seed);
			controller = new Controller(diffLevel, random);
			boolean playAgain = controller.run();
			
			while (playAgain) {		
				random = new Random(seed);
				controller = new Controller(diffLevel, random);
				playAgain = controller.run();
			}
				
		} 
		catch (NumberFormatException e) {
			System.err.print(e);
		}
		catch (WrongArgumentsException e) {
			System.err.print(e);
		}
			
	}
	
	public static void setDiffLevel(Level level) {
		diffLevel = level;
	}
	
	public static void setRandomSeed(long seed) {
		Main.seed = seed;
	}	

}

package tp.p1;

import java.util.Random;

public class Main {
	
	private static Level diffLevel;
	private static Random randomSeed;


	public static void main(String[] args) {
		processArgs(args);
	}
	
	private static boolean processArgs (String[] args) {
		boolean ok = true;
		
		if (args.length == 2) {
			ok = processDiffArg(args[0]);
			processRandomSeedArg(args[1]);
		} 
		else if (args.length == 1) {
			ok = processDiffArg(args[0]);
			randomSeed = new Random(System.currentTimeMillis());
		} 		 
		else {
			ok = false;
		}
		
		return ok;
	}
	
	private static boolean processDiffArg(String arg1) {
		boolean ok = true;
		
		if (arg1.equals("EASY")) {
			diffLevel = Level.EASY;
		} 
		else if(arg1.equals("HARD")) {
			diffLevel = Level.HARD;
		}
		else if (arg1.equals("INSANE")) {
			diffLevel = Level.INSANE;
		} 
		else {
			ok = false;
		}
		
		return ok;
	}
	
	private static void processRandomSeedArg (String arg2) {
		randomSeed = new Random(Long.parseLong(arg2));
	}

}

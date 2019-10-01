package tp.p1;

import java.util.Random;

public class Arguments {
	
	public static boolean processArgs (String[] args) {
		boolean ok = true;
		
		if (args.length == 2) {
			ok = processDiffArg(args[0]);
			processRandomSeedArg(args[1]);
		} 
		else if (args.length == 1) {
			ok = processDiffArg(args[0]);
			Main.setRandomSeed (new Random(System.currentTimeMillis()));
		} 		 
		else {
			ok = false;
		}
		
		return ok;
	}
	
	private static boolean processDiffArg(String arg1) {
		boolean ok = true;
		
		if (arg1.equals("EASY")) {
			Main.setDiffLevel (Level.EASY);
		} 
		else if(arg1.equals("HARD")) {
			Main.setDiffLevel (Level.HARD);
		}
		else if (arg1.equals("INSANE")) {
			Main.setDiffLevel (Level.INSANE);
		} 
		else {
			ok = false;
		}
		
		return ok;
	}
	
	private static void processRandomSeedArg (String arg2) {
		Main.setRandomSeed (new Random(Long.parseLong(arg2)));
	}
}

package tp.p1.model;

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
			Main.setRandomSeed (System.currentTimeMillis());
		} 		 
		else {
			ok = false;
		}
		
		return ok;
	}
	
	private static boolean processDiffArg(String arg1) {
		Level inputLevel = Level.parse(arg1);
		Main.setDiffLevel(inputLevel);
		return (inputLevel != null);
	}
	
	private static void processRandomSeedArg (String arg2) {
		Main.setRandomSeed (Long.parseLong(arg2));
	}
}

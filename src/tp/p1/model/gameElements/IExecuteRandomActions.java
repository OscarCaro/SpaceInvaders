package tp.p1.model.gameElements;

import tp.p1.model.Game;

public interface IExecuteRandomActions {
	
	default void computerAction() {	}
	
	static boolean canGenerateUfo(Game game){
		return game.getRandom().nextInt(10) < 10*game.getDiffLevel().getUfoFrequency();
	}
	
	static boolean canGenerateBomb(Game game){
		return game.getRandom().nextInt(10) < 10*game.getDiffLevel().getShootFrequency();
	}
	
	static boolean canTurnExplosive(Game game){
		return game.getRandom().nextInt(20) == 1; 
	}
	
	static boolean canUpgrade(Game game){
		return game.getRandom().nextInt(25) == 1; 
	}
}

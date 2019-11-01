package tp.p1.model.gameElements;

import tp.p1.model.Game;

public interface IExecuteRandomActions {
	static boolean canGenerateUfo(Game game){
		return game.getRandom().nextInt(10) < 10*game.getLevel().getOvniFrequency();
		}
	static boolean canGenerateBomb(Game game){
		return game.getRandom().nextInt(10) < 10*game.getLevel().getShootFrequency();
		}
}

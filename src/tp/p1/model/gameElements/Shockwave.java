package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class Shockwave extends Weapon {
	public static final int DAMAGE = 1;
	
	public Shockwave(Game game) {
		super(0, 0, game, 1,"");		
	}

	@Override
	public void onDelete() {
		this.game.enableShockWave();
	}

	@Override
	public void move() {
		// Void because shockWave doesn't move 		
	}

	@Override
	public String toString() {
		// Empty string because this function is used to be concatenated in general checkPos 
		return "";
	}
	
	@Override
	public boolean performAttack(GameElements other) {
		return other.receiveShockWaveAttack(DAMAGE);
	}

}

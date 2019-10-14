package tp.p1;

public class BombList {
	
	private Bomb ucmMissile;		// at most one on the board at a given time
	private Bomb [] projectileList;

	public BombList(Level diffLevel) {
		this.projectileList = new Bomb[];
	}
	
}

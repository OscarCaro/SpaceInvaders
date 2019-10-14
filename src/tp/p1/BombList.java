package tp.p1;

public class BombList {
	
	private Bomb ucmMissile;		// at most one on the board at a given time
	private Bomb [] projectileList;

	public BombList(Level diffLevel) {
		// at most one projectile from each destroyer at a given time
		// then the max size of list is the starting number of destroyers
		this.projectileList = new Bomb[diffLevel.getNumOfDestroyers()];	
		// ucmMissile will be created/set-to-null at run time
	}
	
	public boolean isThereUcmMissile () {
		return (ucmMissile != null);		
	}
	
	public int getNumOfValidProjectiles() {
		// Return num of instantiated bombs in projectileList (i.e. num of not null elems)
		int count = 0;
		for (Bomb current : this.projectileList) {
			if (current != null) {
				count++;
			}
		}
		return count;
	}
	
}

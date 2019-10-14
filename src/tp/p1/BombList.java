package tp.p1;

public class BombList {
	
	private Bomb [] projectileList;

	public BombList(Level diffLevel) {
		// at most one projectile from each destroyer at a given time
		// then the max size of list is the starting number of destroyers
		this.projectileList = new Bomb[diffLevel.getNumOfDestroyers()];	
		// ucmMissile will be created/set-to-null at run time
	}
	
	public void newProjectile(int posX, int posY) {
		this.projectileList[getNumOfValidProjectiles()] = new Bomb(posX, posY);
	}
	
	public void deleteProjectile(int posX, int posY) {
		// 1. Find pos in list
		int idx = findProjectile(posX, posY);
		// 2. Remove from list
		this.projectileList[idx] = null;
		// 3. Shift left remaining elements
		for (int i = idx; i < getNumOfValidProjectiles(); i++) {
			this.projectileList[i] = this.projectileList[i + 1];
		}		
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
	
	private int findProjectile(int posX, int posY) {
		int idx = 0;
		boolean found = false;
		while (!found && idx < getNumOfValidProjectiles()) {
			if (this.projectileList[idx].getPosX() == posX && this.projectileList[idx].getPosY() == posY) {
				found = true;
			} else {
				idx++;
			}
		}		
		return idx;
	}
	
}

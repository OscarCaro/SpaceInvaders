package tp.p1;

public class BombList {
	
	private Bomb [] bombList;

	public BombList(Level diffLevel) {
		// at most one projectile from each destroyer at a given time
		// then the max size of list is the starting number of destroyers
		this.bombList = new Bomb[diffLevel.getNumOfDestroyers()];	
		// ucmMissile will be created/set-to-null at run time
	}
	
	public void newBomb(int posX, int posY, Destroyer destroyer) {
		this.bombList[getNumOfValidBombs()] = new Bomb(posX, posY, destroyer);
	}
	
	public void deleteBomb(int posX, int posY) {
		// 1. Find pos in list
		int idx = findBomb(posX, posY);
		// 2. Remove from list
		this.bombList[idx] = null;
		// 3. Shift left remaining elements
		for (int i = idx; i < getNumOfValidBombs(); i++) {
			this.bombList[i] = this.bombList[i + 1];
		}		
	}

	
	public int getNumOfValidBombs() {
		// Return num of instantiated bombs in projectileList (i.e. num of not null elems)
		int count = 0;
		for (Bomb current : this.bombList) {
			if (current != null) {
				count++;
			}
		}
		return count;
	}
	
	private int findBomb(int posX, int posY) {
		int idx = 0;
		boolean found = false;
		while (!found && idx < getNumOfValidBombs()) {
			if (this.bombList[idx].getPosX() == posX && this.bombList[idx].getPosY() == posY) {
				found = true;
			} else {
				idx++;
			}
		}	
		if (!found) {
			idx = -1;
		}
		return idx;
	}
	
	public void incrementPosY(int idx) {
		this.bombList[idx].incrementPosY();
	}
	
}

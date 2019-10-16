package tp.p1;

public class DestroyerList {
	
	private Destroyer[] destroyerList;
	private boolean movingLeft;
	private boolean movingRight;
	
	public DestroyerList( Level diffLevel) {
		int initNumOfDestroyers = diffLevel.getNumOfDestroyers();
		
		if(diffLevel == Level.EASY) {
			createEasy(initNumOfDestroyers);
		}
		
		else if(diffLevel == Level.HARD) {
			createHard(initNumOfDestroyers);
		}
		
		else if(diffLevel == Level.INSANE) {
			createInsane(initNumOfDestroyers);
		}
		
		this.movingLeft = true;
		this.movingRight = false;	
	}
	
	public void deleteDestroyer(int posX, int posY) {
		// 1. Find pos in list
		int idx = findDestroyer(posX, posY);
		
		// 2. Shift left remaining elements
		if (idx != -1) {
			for (int i = idx; i < getNumOfValidDestroyers() - 1; i++) {
				this.destroyerList[i] = this.destroyerList[i + 1];
				
			}	
			
			this.destroyerList[getNumOfValidDestroyers() - 1] = null; 	// Segunda llamada a getvaliddestroyer retorna uno menos 		
			//Delete last element pointer because it is already pointed by the previous one 
			
		}
		
	}

	
	public int getNumOfValidDestroyers() {
		// Return num of instantiated destroyers in destroyerList (i.e. num of not null elems)
		int count = 0;
		for (Destroyer current : this.destroyerList) {
			if (current != null) {
				count++;
			}
		}
		return count;
	}
	
	private int findDestroyer(int posX, int posY) {
		int idx = 0;
		boolean found = false;
		while (!found && idx < getNumOfValidDestroyers()) {
			if (this.destroyerList[idx].getPosX() == posX && this.destroyerList[idx].getPosY() == posY) {
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
	
	public boolean destroyersInBottomRow() {
		boolean is = false;
		for (int i = 0; i < this.getNumOfValidDestroyers(); i++) {
			if (this.destroyerList[i].getPosY() == Board.ROWS - 1) {
				is = true;
			}
		}
		return is;
	}
	
	public String checkPos (int x, int y) {
		String str = "";
		int i = 0;
		boolean found = false;
		while ( i < this.getNumOfValidDestroyers() && !found) {
			if (destroyerList[i].getPosX() == x && destroyerList[i].getPosY() == y) {
				str = destroyerList[i].toString();
				found = true;
			}
			i++;
		}
		return str;
	}
	
	public Destroyer getDestroyer(int idx) {
		return this.destroyerList[idx];
	}
	
	public boolean destroyerCanShoot(int idx) {
		return this.destroyerList[idx].isCanShoot();
	}
	
	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
		this.movingRight = !movingLeft;	
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}


	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
		this.movingLeft = !movingRight; 
	}
	
	public boolean isMovingRight() {
		return movingRight;
	}
	

	public int minDistToLeftSide() {
		int minDist = -1;
		
		if (destroyerList.length > 0) {
			minDist = destroyerList[0].getPosX();
			for (int i = 1; i < this.getNumOfValidDestroyers(); i++) {				
				if (destroyerList[i].getPosX() < minDist) {
					minDist = destroyerList[i].getPosX();
				}
			}
		}		
		return minDist;
	}
	
	public int minDistToRightSide() {
		int minDist = -1;
		
		if (destroyerList.length > 0) {
			minDist = Board.ROWS - destroyerList[0].getPosX();
			for (int i = 1; i < this.getNumOfValidDestroyers(); i++) {				
				if (Board.ROWS - destroyerList[i].getPosX() < minDist) {
					minDist = Board.ROWS - destroyerList[i].getPosX();
				}
			}
		}		
		return minDist;
	}
	

	public void moveDestroyerToLeft (int idx) {
		int nextPos = this.destroyerList[idx].getPosX() - 1;
		this.destroyerList[idx].setPosX(nextPos);
	}
	
	public void moveDestroyerToRight (int idx) {
		int nextPos = this.destroyerList[idx].getPosX() + 1;
		this.destroyerList[idx].setPosX(nextPos);
	}
	
	public void moveDestroyerDown (int idx) {
		int nextPos = this.destroyerList[idx].getPosY() + 1;
		this.destroyerList[idx].setPosY(nextPos);
	}


	
	public void createEasy(int initNumOfDestroyers) {
		int posX = 4;
		int posY = 2;
		
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			destroyerList[i] = new Destroyer( posX,  posY, i);
			posX++;
		}
		
	}
	
	public void createHard(int initNumOfDestroyers) {
		int posX = 4;
		int posY = 3;
		
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			destroyerList[i] = new Destroyer( posX,  posY, i);
			posX++;
		}
	}
	
	public void createInsane(int initNumOfDestroyers) {
		int posX = 3;
		int posY = 3;
		
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			destroyerList[i] = new Destroyer( posX,  posY, i);
			posX++;
		}
	}
	
//	public int getNumOfDestroyers() {
//		return this.destroyerList.length;
//	}
	
	public int getPosX(int idx) {
		return this.destroyerList[idx].getPosX();
	}
	
	public int getPosY(int idx) {
		return this.destroyerList[idx].getPosY();
	}
	
	public void decrementShield(int idx) {
		this.destroyerList[idx].decrementShield();
	}
	
	public int getShield(int idx) {
		return this.destroyerList[idx].getShield();
	}
	
	public int getDestroyerScore(int idx) {
		return this.destroyerList[idx].getPoints();
	}
}

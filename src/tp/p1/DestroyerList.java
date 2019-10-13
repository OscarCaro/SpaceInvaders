package tp.p1;

public class DestroyerList {
	
	private Destroyer[] destroyerList;
	private boolean movingLeft;
	private boolean movingRight;
	
	public DestroyerList( Board boardObj, Level diffLevel) {
		int initNumOfDestroyers = diffLevel.getNumOfDestroyers();
		
		if(diffLevel == Level.EASY) {
			createEasy(boardObj, initNumOfDestroyers);
		}
		
		else if(diffLevel == Level.HARD) {
			createHard(boardObj, initNumOfDestroyers);
		}
		
		else if(diffLevel == Level.INSANE) {
			createInsane(boardObj, initNumOfDestroyers);
		}
		
		this.movingLeft = true;
		this.movingRight = false;	
	}
	
	public String checkPos (int x, int y) {
		String str = "";
		int i = 0;
		boolean found = false;
		while ( i < destroyerList.length && !found) {
			if (destroyerList[i].getPosX() == x && destroyerList[i].getPosY() == y) {
				str = destroyerList[i].toString();
				found = true;
			}
			i++;
		}
		return str;
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
			for (int i = 1; i < destroyerList.length; i++) {				
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
			minDist = Board.ROWS - 1 - destroyerList[0].getPosX();
			for (int i = 1; i < destroyerList.length; i++) {				
				if (Board.ROWS - 1 - destroyerList[i].getPosX() < minDist) {
					minDist = Board.ROWS - 1 - destroyerList[i].getPosX();
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


	
	public void createEasy( Board boardObj, int initNumOfDestroyers) {
		int posX = 4;
		int posY = 2;
		
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			destroyerList[i] = new Destroyer( posX,  posY);
			posX++;
		}
		
	}
	
	public void createHard( Board boardObj, int initNumOfDestroyers) {
		int posX = 4;
		int posY = 3;
		
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			destroyerList[i] = new Destroyer( posX,  posY);
			posX++;
		}
	}
	
	public void createInsane( Board boardObj, int initNumOfDestroyers) {
		int posX = 3;
		int posY = 3;
		
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			destroyerList[i] = new Destroyer( posX,  posY);
			posX++;
		}
	}
	
	public int getNumOfDestroyers() {
		return this.destroyerList.length;
	}
}

package tp.p1;

public class CarrierList {
	
	private Carrier[] carrierList;	
	private boolean movingLeft;
	private boolean movingRight;
	
	public CarrierList(Level diffLevel) {
		int initNumOfCarriers = diffLevel.getNumOfCarriers();
		
		if(diffLevel == Level.EASY) {
			createEasy(initNumOfCarriers);
		}
		
		else if(diffLevel == Level.HARD) {
			createHard(initNumOfCarriers);
		}
		
		else if(diffLevel == Level.INSANE) {
			createInsane(initNumOfCarriers);
		}
		
		this.movingLeft = true;
		this.movingRight = false;
	}
	
	public int minDistToLeftSide() {
		int minDist = -1;
		
		if (carrierList.length > 0) {
			minDist = carrierList[0].getPosX();
			for (int i = 1; i < carrierList.length; i++) {				
				if (carrierList[i].getPosX() < minDist) {
					minDist = carrierList[i].getPosX();
				}
			}
		}		
		return minDist;
	}
	
	public int minDistToRightSide() {
		int minDist = -1;
		
		if (carrierList.length > 0) {
			minDist = Board.ROWS - 1 - carrierList[0].getPosX();
			for (int i = 1; i < carrierList.length; i++) {				
				if (Board.ROWS - 1 - carrierList[i].getPosX() < minDist) {
					minDist = Board.ROWS - 1 - carrierList[i].getPosX();
				}
			}
		}		
		return minDist;
	}
	
	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
		this.movingRight = !movingLeft;	// To make sure both of them are never true at the same time
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
		this.movingLeft = !movingRight; // To make sure both of them are never true at the same time
	}
	
	public void moveCarierToLeft (int idx) {
		int nextPos = this.carrierList[idx].getPosX() - 1;
		this.carrierList[idx].setPosX(nextPos);
	}
	
	public void moveCarierToRight (int idx) {
		int nextPos = this.carrierList[idx].getPosX() + 1;
		this.carrierList[idx].setPosX(nextPos);
	}
	
	public void moveCarierDown (int idx) {
		int nextPos = this.carrierList[idx].getPosY() + 1;
		this.carrierList[idx].setPosY(nextPos);
	}

	public String checkPos (int x, int y) {
		String str = "";
		int i = 0;
		boolean found = false;
		while ( i < carrierList.length && !found) {
			if (carrierList[i].getPosX() == x && carrierList[i].getPosY() == y) {
				str = carrierList[i].toString();
				found = true;
			}
			i++;
		}
		return str;
	}
	
	public void createEasy(int initNumOfCarriers) {
		int posX = 3;
		int posY = 1;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			carrierList[i] = new Carrier(posX,  posY);
			posX++;
		}
		
	}
	
	public void createHard(int initNumOfCarriers) {
		int posX = 3;
		int posY = 1;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			if(i == 4) {
				posY++;
				posX = 3;
			}
			carrierList[i] = new Carrier(posX,  posY);
			posX++;
		}
		
	}
	
	public void createInsane(int initNumOfCarriers) {
		int posX = 3;
		int posY = 1;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			
			if(i == 4) {
				posY++;
				posX = 3;
			}
			
			carrierList[i] = new Carrier(posX,  posY);
			posX++;
		}		
	}
	
	public int getNumOfCarriers() {
		return this.carrierList.length;
	}
	
}

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
	
	public void deleteCarrier(int posX, int posY) {
		boolean listShifted = false;
		// 1. Find pos in list
		int idx = findCarrier(posX, posY);
		
		// 2. Shift left remaining elements
		if (idx != -1) {
			for (int i = idx; i < getNumOfValidCarriers() - 1; i++) {
				listShifted = true;
				this.carrierList[i] = this.carrierList[i + 1];
				
			}	
			if (listShifted) {
				this.carrierList[getNumOfValidCarriers() - 1] = null; 	// Segunda llamada a getvalidcarrier retorna una menos 		
				//Delete last element pointer because it is already pointed by the previous one 
			}
		}
		
	}
	
	private int findCarrier(int posX, int posY) {
		int idx = 0;
		boolean found = false;
		while (!found && idx < getNumOfValidCarriers()) {
			if (this.carrierList[idx].getPosX() == posX && this.carrierList[idx].getPosY() == posY) {
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
	
	public int getNumOfValidCarriers() {
		// Return num of instantiated carriers in carrierList (i.e. num of not null elems)
		int count = 0;
		for (Carrier current : this.carrierList) {
			if (current != null) {
				count++;
			}
		}
		return count;
	}
	
	public int minDistToLeftSide() {
		int minDist = -1;
		
		if (carrierList.length > 0) {
			minDist = carrierList[0].getPosX();
			for (int i = 1; i < this.getNumOfValidCarriers(); i++) {				
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
			minDist = Board.ROWS - carrierList[0].getPosX();
			for (int i = 1; i < this.getNumOfValidCarriers(); i++) {				
				if (Board.ROWS - carrierList[i].getPosX() < minDist) {
					minDist = Board.ROWS - carrierList[i].getPosX();
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
	
	public boolean carriersInBottomRow() {
		boolean is = false;
		for (int i = 0; i < this.getNumOfValidCarriers(); i++) {
			if (this.carrierList[i].getPosY() == Board.ROWS - 1) {
				is = true;
			}
		}
		return is;
	}

	public String checkPos (int x, int y) {
		String str = "";
		int i = 0;
		boolean found = false;
		while ( i < this.getNumOfValidCarriers() && !found) {
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
	
//	public int getNumOfCarriers() {
//		return this.carrierList.length;
//	}
	
	public int getPosX(int idx) {
		return this.carrierList[idx].getPosX();
	}
	
	public int getPosY(int idx) {
		return this.carrierList[idx].getPosY();
	}
	
	public void decrementShield(int idx) {
		this.carrierList[idx].decrementShield();
	}
	
	public int getShield(int idx) {
		return this.carrierList[idx].getShield();
	}
	
	public int getCarrierScore(int idx) {
		return this.carrierList[idx].getPoints();
	}
	
}

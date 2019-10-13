package tp.p1;

public class CarrierList {
	
	private Carrier[] carrierList;	
	
	public CarrierList( Board boardObj, Level diffLevel) {
		int initNumOfCarriers = diffLevel.getNumOfCarriers();
		
		if(diffLevel == Level.EASY) {
			createEasy(boardObj, initNumOfCarriers);
		}
		
		else if(diffLevel == Level.HARD) {
			createHard(boardObj, initNumOfCarriers);
		}
		
		else if(diffLevel == Level.INSANE) {
			createInsane(boardObj, initNumOfCarriers);
		}

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
	
	public void createEasy( Board boardObj, int initNumOfCarriers) {
		int posX = 3;
		int posY = 1;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			carrierList[i] = new Carrier(false,  posX,  posY);
			posX++;
		}
		
	}
	
	public void createHard(Board boardObj, int initNumOfCarriers) {
		int posX = 3;
		int posY = 1;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			if(i == 4) {
				posY++;
				posX = 3;
			}
			carrierList[i] = new Carrier(false,  posX,  posY);
			posX++;
		}
		
	}
	
	public void createInsane(Board boardObj, int initNumOfCarriers) {
		int posX = 3;
		int posY = 1;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			
			if(i == 4) {
				posY++;
				posX = 3;
			}
			
			carrierList[i] = new Carrier(false,  posX,  posY);
			posX++;
		}		
	}
	
	public int getNumOfCarriers() {
		return this.carrierList.length;
	}
	
}

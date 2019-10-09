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
		int posY = 2;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
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
	
}

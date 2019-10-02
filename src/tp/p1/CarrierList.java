package tp.p1;

public class CarrierList {
	
	private Carrier[] carrierList;	
	
	public CarrierList(Level diffLevel, CellTypes[][] enumBoard) {
		int initNumOfCarriers = diffLevel.getNumOfCarriers();
		
		if(diffLevel == Level.EASY) {
			createEasy(initNumOfCarriers, enumBoard);
		}
		
		else if(diffLevel == Level.HARD) {
			createHard(initNumOfCarriers, enumBoard);
		}
		
		else if(diffLevel == Level.INSANE) {
			createInsane(initNumOfCarriers, enumBoard);
		}

	}
	
	public void createEasy(int initNumOfCarriers, CellTypes[][] enumBoard) {
		int posX = 3;
		int posY = 1;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			carrierList[i] = new Carrier(false,  posX,  posY);
			posX++;
		}
		
	}
	
	public void createHard(int initNumOfCarriers, CellTypes[][] enumBoard) {
		int posX = 3;
		int posY = 2;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			carrierList[i] = new Carrier(false,  posX,  posY);
			posX++;
		}
		
	}
	
	public void createInsane(int initNumOfCarriers, CellTypes[][] enumBoard) {
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

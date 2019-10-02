package tp.p1;

public class CarrierList {
	
	private Carrier[] carrierList;	
	
	public CarrierList( Board boardObj, Level diffLevel, CellTypes[][] enumBoard) {
		int initNumOfCarriers = diffLevel.getNumOfCarriers();
		
		if(diffLevel == Level.EASY) {
			createEasy(boardObj, initNumOfCarriers, enumBoard);
		}
		
		else if(diffLevel == Level.HARD) {
			createHard(boardObj, initNumOfCarriers, enumBoard);
		}
		
		else if(diffLevel == Level.INSANE) {
			createInsane(boardObj, initNumOfCarriers, enumBoard);
		}

	}
	
	public void createEasy( Board boardObj, int initNumOfCarriers, CellTypes[][] enumBoard) {
		int posX = 3;
		int posY = 1;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			carrierList[i] = new Carrier(false,  posX,  posY);
			boardObj.fillEnumBoardPosition(CellTypes.CARRIER, posX, posY, i);
			posX++;
		}
		
	}
	
	public void createHard(Board boardObj, int initNumOfCarriers, CellTypes[][] enumBoard) {
		int posX = 3;
		int posY = 2;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			carrierList[i] = new Carrier(false,  posX,  posY);
			boardObj.fillEnumBoardPosition(CellTypes.CARRIER, posX, posY, i);
			posX++;
		}
		
	}
	
	public void createInsane(Board boardObj, int initNumOfCarriers, CellTypes[][] enumBoard) {
		int posX = 3;
		int posY = 1;
		
		this.carrierList = new Carrier [initNumOfCarriers];
		
		for (int i = 0; i < initNumOfCarriers; i++ ) {
			
			if(i == 4) {
				posY++;
				posX = 3;
			}
			
			carrierList[i] = new Carrier(false,  posX,  posY);
			boardObj.fillEnumBoardPosition(CellTypes.CARRIER, posX, posY, i);
			posX++;
		}
		
	}
	
}

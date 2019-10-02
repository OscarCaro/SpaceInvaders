package tp.p1;

public class CarrierList {
	
	private Carrier[] carrierList;	
	
	public CarrierList(Level diffLevel, CellTypes[][] enumBoard) {
		int initNumOfCarriers = diffLevel.getNumOfCarriers();
		
		int posX = 3;
		int posY = 1; //always in row 1 except for hard and insane, that the 4 remaining go to row 2
		boolean isUfo = false;
		// The max amount of carriers at the same time is the initial number (determined by difficulty)
		this.carrierList = new Carrier [initNumOfCarriers];
		for (int i = 0; i < initNumOfCarriers; i++) {
			// ToDo: for each new Carrier, determine position and uncomment the next
			 if (i == 4) {
				 posY++;	//if i has 5 iterations (There are more than 4 ships) goes to next row 
				 posX = 3;
			 }			//(About the comment above) Equivalent to levels hard and insane
			 carrierList[i] = new Carrier(isUfo,  posX,  posY);
			 posX++;
		}
	}
	
	
	
}

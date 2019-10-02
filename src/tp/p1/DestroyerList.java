package tp.p1;

public class DestroyerList {
	
	private Destroyer[] destroyerList;
	
	public DestroyerList(Level diffLevel, CellTypes[][] enumBoard) {
		int initNumOfDestroyers; // ToDo: Give value according to difflevel
		
		int posX = 4; 	//Same planning as for carrierList.
		int posY = 2;
		
		// The max amount of carriers at the same time is the initial number (determined by difficulty)
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		for (int i = 0; i < initNumOfDestroyers; i++) {
			
			// ToDo: Adjust posX and posY for each new destroyer (as in carrierList)
			destroyerList[i] = new Destroyer(posX, posY);
			
			//ToDo: Adjust conditions for levels hard and insane.
		}
	}}

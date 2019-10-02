package tp.p1;

public class DestroyerList {
	
	private Destroyer[] destroyerList;
	
	public DestroyerList( Board boardObj, Level diffLevel, CellTypes[][] enumBoard) {
		int initNumOfDestroyers = diffLevel.getNumOfDestroyers();
		
		if(diffLevel == Level.EASY) {
			createEasy(boardObj, initNumOfDestroyers, enumBoard);
		}
		
		else if(diffLevel == Level.HARD) {
			createHard(boardObj, initNumOfDestroyers, enumBoard);
		}
		
		else if(diffLevel == Level.INSANE) {
			createInsane(boardObj, initNumOfDestroyers, enumBoard);
		}
		
	}
	
	
	public void createEasy( Board boardObj, int initNumOfDestroyers, CellTypes[][] enumBoard) {
		int posX = 4;
		int posY = 2;
		
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			destroyerList[i] = new Destroyer( posX,  posY);
			boardObj.fillEnumBoardPosition(CellTypes.DESTROYER, posX, posY, i);
			posX++;
		}
		
	}
	
	public void createHard( Board boardObj, int initNumOfDestroyers, CellTypes[][] enumBoard) {
		int posX = 4;
		int posY = 3;
		
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			destroyerList[i] = new Destroyer( posX,  posY);
			boardObj.fillEnumBoardPosition(CellTypes.DESTROYER, posX, posY, i);
			posX++;
		}
	}
	
	public void createInsane( Board boardObj, int initNumOfDestroyers, CellTypes[][] enumBoard) {
		int posX = 3;
		int posY = 3;
		
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		
		
		
		for (int i = 0; i < initNumOfDestroyers; i++ ) {
			destroyerList[i] = new Destroyer( posX,  posY);
			boardObj.fillEnumBoardPosition(CellTypes.DESTROYER, posX, posY, i);
			posX++;
		}
	}
}

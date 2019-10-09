package tp.p1;

public class DestroyerList {
	
	private Destroyer[] destroyerList;
	
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
}

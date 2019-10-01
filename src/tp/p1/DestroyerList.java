package tp.p1;

public class DestroyerList {
	
	private Destroyer[] destroyerList;
	
	int posX = 4;
	int posY = 2;
	
	public DestroyerList(int initNumOfDestroyers) {
		// The max amount of carriers at the same time is the initial number (determined by difficulty)
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		for (int i = 0; i < initNumOfDestroyers; i++) {
			destroyerList[i] = new Destroyer(posX, posY);
			
			//ToDo: Adjust conditions for levels hard and insane.
		}
	}}

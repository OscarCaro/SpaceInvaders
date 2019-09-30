package tp.p1;

public class DestroyerList {
	
	private Destroyer[] destroyerList;
	
	public DestroyerList(int initNumOfDestroyers) {
		// The max amount of carriers at the same time is the initial number (determined by difficulty)
		this.destroyerList = new Destroyer [initNumOfDestroyers];
		for (int i = 0; i < initNumOfDestroyers; i++) {
			// ToDo: for each new Destroyer, determine position and uncomment the next
			// destroyerList[i] = new Destroyer( int posX, int posY);
		}
	}}

package tp.p1;

public class CarrierList {
	
	private Carrier[] carrierList;
	
	
	public CarrierList(int initNumOfCarriers) {
		int posX = 3;
		int posY = 1; //siempre se queda en la fila 1;
		boolean isUfo = false;
		// The max amount of carriers at the same time is the initial number (determined by difficulty)
		this.carrierList = new Carrier [initNumOfCarriers];
		for (int i = 0; i < initNumOfCarriers; i++) {
			// ToDo: for each new Carrier, determine position and uncomment the next
			 if (i == 4) {
				 posY++;	//Si llega a la quinta iteración tenemos que seguir los
			 }				// cuatro carrier restantes en la fila de abajo.
			 carrierList[i] = new Carrier(isUfo,  posX,  posY);
			 posX++;

		}
	}
}

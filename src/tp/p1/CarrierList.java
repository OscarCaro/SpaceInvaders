package tp.p1;

public class CarrierList {
	
	private Carrier[] carrierList;
	
	public CarrierList(int initNumOfCarriers) {
		// The max amount of carriers at the same time is the initial number (determined by difficulty)
		this.carrierList = new Carrier [initNumOfCarriers];
		for (int i = 0; i < initNumOfCarriers; i++) {
			// ToDo: for each new Carrier, determine position and uncomment the next
			// carrierList[i] = new Carrier(bool isUfo, int posX, int posY);
		}
	}
}

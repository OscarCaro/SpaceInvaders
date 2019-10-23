package tp.p1.model;

public enum Level {
	
	EASY (4, 2, 10, 3, 2),
	HARD (8, 2, 3, 2, 5),
	INSANE (8, 4, 2, 1, 10);
	
	private int numOfCarriers;
	private int numOfDestroyers;
	private int fireFreq;
	private int speed;			// CAUTION: measured in number of cycles per (single-square) movement -> The lower, the faster
	private int ufoFreq;
	
	private Level(int numOfCarriers, int numOfDestroyers, int fireFreq, int speed, int ufoFreq) {
		this.numOfCarriers = numOfCarriers;
		this.numOfDestroyers = numOfDestroyers;
		this.fireFreq = fireFreq;
		this.speed = speed;
		this.ufoFreq = ufoFreq;
	}
	
	public int getNumOfCarriers () {
		return numOfCarriers;
	}
	
	public int getNumOfDestroyers() {
		return numOfDestroyers;
	}
	
	public int getFireFreq() {
		return fireFreq;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getUfoFreq() {
		return ufoFreq;
	}
	
}

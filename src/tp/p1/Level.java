package tp.p1;

public enum Level {
	
	EASY (4, 2, 10, 3, 0.5),
	HARD (8, 2, 3, 2, 0.2),
	INSANE (8, 4, 2, 1, 0.1);
	
	private int numOfCarriers;
	private int numOfDestroyers;
	private int fireFreq;
	private int speed;			// CAUTION: measured in number of cycles per (single-square) movement -> The lower, the faster
	private double ufoFreq;
	
	private Level(int numOfCarriers, int numOfDestroyers, int fireFreq, int speed, double ufoFreq) {
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
	
	public double getUfoFreq() {
		return ufoFreq;
	}
	
}

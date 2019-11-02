package tp.p1.model;

public enum Level {

	EASY(4, 2, 0.2, 3, 0.5, 1),
	HARD(8, 4, 0.3, 2, 0.2, 2),
	INSANE(12, 4, 0.5, 1, 0.1, 3);
	
	private int numCarriers;
	private int numDestroyers;
	private int numCyclesToMove;
	private double ufoFreq;
	private double shootFreq;
	private int numRowsOfCarriers;
//	private double turnExplosiveFreq = 0.05; // currently independent of level	

	private Level( int numCarrierShips, int numDestroyerShips, double shootFrequency,
				   int numCyclesToMoveOneCell, double ufoFrequency, int numRowsOfCarrierShips) {
		
		numCarriers = numCarrierShips;
		numDestroyers = numDestroyerShips;
		shootFreq = shootFrequency;
		numCyclesToMove = numCyclesToMoveOneCell;
		ufoFreq = ufoFrequency;
		numRowsOfCarriers = numRowsOfCarrierShips;
	}
	
	public int getNumCarrierShips() {
		return numCarriers;
	}
	
	public int getNumDestroyers() {
		return numDestroyers;
	}
	
	public Double getShootFrequency() {
		return shootFreq;
	}
	
	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMove;
	}
	
	public double getUfoFrequency() {
		return ufoFreq;
	}
	
	public int getNumRowsOfCarrierShips() {
		return numRowsOfCarriers;
	}
	
	public int getNumCarrierShipsPerRow() {
		return numCarriers / numRowsOfCarriers;
	}
	
	public int getNumDestroyersPerRow() {
		return getNumDestroyers();
	}
	
	public static Level parse(String inputString) {
		for (Level level : Level.values() ) {
			if (level.name().equalsIgnoreCase(inputString)) {
				return level;
			}
		}		
		return null;
	}
	
		
//	public Double turnExplosiveFrequency(){
//		return turnExplosiveFreq;
//	}
	
}





//public enum Level {
//	
//	EASY (4, 2, 10, 3, 2),
//	HARD (8, 2, 3, 2, 5),
//	INSANE (8, 4, 2, 1, 10);
//	
//	private int numOfCarriers;
//	private int numOfDestroyers;
//	private int fireFreq;
//	private int speed;			// CAUTION: measured in number of cycles per (single-square) movement -> The lower, the faster
//	private int ufoFreq;
//	
//	private Level(int numOfCarriers, int numOfDestroyers, int fireFreq, int speed, int ufoFreq) {
//		this.numOfCarriers = numOfCarriers;
//		this.numOfDestroyers = numOfDestroyers;
//		this.fireFreq = fireFreq;
//		this.speed = speed;
//		this.ufoFreq = ufoFreq;
//	}
//	
//	public int getNumOfCarriers () {
//		return numOfCarriers;
//	}
//	
//	public int getNumOfDestroyers() {
//		return numOfDestroyers;
//	}
//	
//	public int getFireFreq() {
//		return fireFreq;
//	}
//	
//	public int getSpeed() {
//		return speed;
//	}
//	
//	public int getUfoFreq() {
//		return ufoFreq;
//	}
//	
//}

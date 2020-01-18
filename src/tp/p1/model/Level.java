package tp.p1.model;

public enum Level {

	EASY(4, 2, 0, 0.2, 3, 0.5, 1),
	HARD(8, 4,0, 0.3, 2, 0.2, 2),
	INSANE(12,4, 2, 0.5, 1, 0.1, 3);
	
	private int numCarriers;
	private int numDestroyers;
	private int numCommanders;
	private int numCyclesToMove;
	private double ufoFreq;
	private double shootFreq;
	private int numRowsOfCarriers;	

	private Level( int numCarrierShips, int numDestroyerShips, int numCommanderShips, double shootFrequency,
				   int numCyclesToMoveOneCell, double ufoFrequency, int numRowsOfCarrierShips) {
		
		numCarriers = numCarrierShips;
		numDestroyers = numDestroyerShips;
		numCommanders = numCommanderShips;
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
	
	public int getNumCommanders() {
		return numCommanders;
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

}

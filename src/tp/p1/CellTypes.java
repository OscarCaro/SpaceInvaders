package tp.p1;

public enum CellTypes {
	UCM_SHIP(),
	CARRIER(),
	DESTROYER(),
	UFO(),
	MISSILE(),
	EMPTY();
	
	private int posInList;	// Store the position of, lets say, a carrier, in the array of carrierList
	
	private CellTypes () {
	}
	
	public void setPosInList(int posInList) {
		this.posInList = posInList;
	}
	
}

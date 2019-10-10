package tp.p1;

public class Board {
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 9;
	
	//private CellTypes[][] enumBoard;
	
	private CarrierList carrierList;
	private DestroyerList destroyerList;
	private BombList bombList;
	private UCM_Ship ucm_Ship;
	
	
	public Board (Level diffLevel) {
		this.carrierList = new CarrierList(this, diffLevel);
		this.destroyerList = new DestroyerList(this, diffLevel);
		this.bombList = new BombList();	
		this.ucm_Ship = new UCM_Ship();
	}
	
	public String checkCarrierListPos(int x, int y) {
		return carrierList.checkPos(x, y);
	}

	public String checkDestroyerListPos(int x, int y) {
		return destroyerList.checkPos(x, y);
	}
	
	public String checkUcmShip (int x, int y) {
		return ucm_Ship.checkPos(x, y);
	}

}

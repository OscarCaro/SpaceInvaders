package tp.p1;

public class Board {
	private CarrierList carrierList;
	private DestroyerList destroyerList;
	private BombList bombList;
	
	public Board () {
		this.carrierList = new CarrierList();
		this.destroyerList = new DestroyerList();
		this.bombList = new BombList();
	}
}

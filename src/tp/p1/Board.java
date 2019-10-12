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
		this.bombList = new BombList(this, diffLevel);	
		this.ucm_Ship = new UCM_Ship();
	}
	
	public void moveUcmShip(boolean left, boolean right, int numOfCells) {
		// Todo: develop movement (already half developed in controller class
		int posX = this.ucm_Ship.getPosX();
		
		if(left == true) {

			if(numOfCells == 1) {
				if(posX == 0) {
					this.ucm_Ship.setPosX(8);
				}
				
				else {
					this.ucm_Ship.setPosX(posX - 1);
				}
			}
			
			else if(numOfCells == 2)  {
				if(posX == 0) {
					this.ucm_Ship.setPosX(7);
				}
				
				else if(posX == 1) {
					this.ucm_Ship.setPosX(8);
				}
				
				else {
					this.ucm_Ship.setPosX(posX - 2);
				}
			}	
		}
		
		else if(right == true) {
			if(numOfCells == 1) {
				if(posX == 8) {
					this.ucm_Ship.setPosX(0);
				}
				
				else {
					this.ucm_Ship.setPosX(posX + 1);
				}
			}
			
			else if(numOfCells == 2)  {
				if(posX == 7) {
					this.ucm_Ship.setPosX(0);
				}
				
				else if(posX == 8) {
					this.ucm_Ship.setPosX(1);
				}
				
				else {
					this.ucm_Ship.setPosX(posX + 2);
				}
			}	
		}
		
	}

	public int getNumOfCarriers() {
		return this.carrierList.getNumOfCarriers();
	}
	
	public int getNumOfDestroyers() {
		return this.destroyerList.getNumOfDestroyers();
	}
	
	public int getUcmShipShield() {
		return this.ucm_Ship.getShield();
	}
	
	public boolean getUcmShipIsShock() {
		return this.ucm_Ship.isShock();
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

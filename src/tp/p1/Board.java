package tp.p1;

public class Board {
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 9;
		
	private CarrierList carrierList;
	private DestroyerList destroyerList;
	private BombList bombList;
	private UCM_Ship ucm_Ship;
	
	
	public Board (Level diffLevel) {
		this.carrierList = new CarrierList(diffLevel);
		this.destroyerList = new DestroyerList(diffLevel);
		this.bombList = new BombList(diffLevel);	
		this.ucm_Ship = new UCM_Ship();
	}
	
	public void moveCarrierListLeft () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.carrierList.getNumOfCarriers(); i++) {
			this.carrierList.moveCarierToLeft(i);
		}
	}
	
	public void moveCarrierListRight () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.carrierList.getNumOfCarriers(); i++) {
			this.carrierList.moveCarierToRight(i);
		}
	}
	
	public void moveCarrierListDown () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.carrierList.getNumOfCarriers(); i++) {
			this.carrierList.moveCarierDown(i);
		}
	}
	
	public void moveDestroyerListLeft () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.destroyerList.getNumOfDestroyers(); i++) {
			this.destroyerList.moveDestroyerToLeft(i);
		}
	}
	
	public void moveDestroyerListRight () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.destroyerList.getNumOfDestroyers(); i++) {
			this.destroyerList.moveDestroyerToRight(i);
		}
	}
	
	public void moveDestroyerListDown () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.destroyerList.getNumOfDestroyers(); i++) {
			this.destroyerList.moveDestroyerDown(i);
		}
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
	
	//CARRIER MOVEMENT//
	
	public int carrMinDistToLeftSide() {
		return this.carrierList.minDistToLeftSide();
	}
	
	public int carrMinDistToRightSide() {
		return carrierList.minDistToRightSide();
	}
	
	public boolean carrierListIsMovingLeft() {
		return carrierList.isMovingLeft();
	}

	public void carrierListSetMovingLeft(boolean movingLeft) {
		carrierList.setMovingLeft(movingLeft);
	}

	public boolean carrierListIsMovingRight() {
		return carrierList.isMovingRight();
	}

	public void carrierListSetMovingRight(boolean movingRight) {
		carrierList.setMovingRight(movingRight);
	}
	
	///////////////////////////////////////////////////////
	
	
	//DESTROYER MOVEMENT//
	
	public int destMinDistToLeftSide() {
		return this.destroyerList.minDistToLeftSide();
	}
	
	public int destMinDistToRightSide() {
		return destroyerList.minDistToRightSide();
	}
	
	public boolean destroyerListIsMovingLeft() {
		return destroyerList.isMovingLeft();
	}

	public void destroyerListSetMovingLeft(boolean movingLeft) {
		 destroyerList.setMovingLeft(movingLeft);
	}

	public boolean destroyerListIsMovingRight() {
		return destroyerList.isMovingRight();
	}

	public void destroyerListSetMovingRight(boolean movingRight) {
		destroyerList.setMovingRight(movingRight);
	}
	
	//////////////////////////////////////////////////
	
	
	//GETTERS, SETTERS AND CHECKERS//

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
	
	///////////////////////////////////////////////////////////
	
}

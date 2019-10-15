package tp.p1;

public class Board {
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 9;
		
	private CarrierList carrierList;
	private DestroyerList destroyerList;
	private BombList bombList;
	private UCM_Ship ucm_Ship;
	private UCM_Missile ucm_Missile;
	
	
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
	
	public void shootUcmMissile() {
		this.ucm_Missile = new UCM_Missile(this.ucm_Ship.getPosX(), this.ucm_Ship.getPosY());
		ucmShipSetCanShoot(false);
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
	
	public void moveDownBombs() {
		for (int i = 0; i < this.getNumOfValidBombs(); i++) {
			this.bombList.incrementPosY(i);
			//Check if out of board -> to destroy the object + destroyer.canShoot = true
			if(this.bombOutOfBoard(i)) {
				this.bombList.deleteBomb(this.bombList.getPosX(i), this.bombList.getPosY(i));
			}
			else if (bombCheckCollitions(this.bombList.getPosX(i), this.bombList.getPosY(i))) {
				
			}
			else if (bombCheckCollitions(this.bombList.getPosX(i), this.bombList.getPosY(i))) {
				this.bombList.deleteBomb(this.bombList.getPosX(i), this.bombList.getPosY(i));
			}
			
		}
	}
	
	public boolean bombCheckCollitions(int posX, int posY) {
		boolean coll = false;
		// Check in carrierList
		if (this.ucm_Ship.getPosX() == posX && this.ucm_Ship.getPosY() == posY) {
			// collition with ucmShip -> decrement shield + remove bomb
			this.ucm_Ship.decrementShield();
			coll = true;
		}
		if(missileExists()) {
		if (this.ucm_Missile.getPosX() == posX && this.ucm_Missile.getPosY() == posY - 1) {
			// collition with ucmMissile -> remove missile and bomb
			deleteUcmMissile();
			
			coll = true;
			}
		}
		
		return coll;
	}
	
	
	
	public void launchMissile() {
		this.ucm_Missile.decrementPosY();
		if(this.outOfBoard()) {
			deleteUcmMissile();
		}
		else if (missileCheckCollitions(this.ucm_Missile.getPosX(), this.ucm_Missile.getPosY())) {
			deleteUcmMissile();
		}
	}
	
	public boolean missileCheckCollitions(int posX, int posY) {
		boolean coll = false;
		// Check in carrierList
		if (this.ucm_Ship.getPosX() == posX && this.ucm_Ship.getPosY() == posY - 1) {
			// collition with ucmShip -> decrement shield + remove bomb
			this.ucm_Ship.decrementShield();
			coll = true;
		}
		if (this.ucm_Missile.getPosX() == posX && this.ucm_Missile.getPosY() == posY - 1) {
			// collition with ucmMissile -> remove missile and bomb
			deleteUcmMissile();
			coll = true;
		}
		
		return coll;
	}
	
	public void deleteUcmMissile() {
		this.ucm_Ship.setCanShoot(true);
		this.ucm_Missile = null;
	}
	
	public void checkBombsOutOfBoard() {
		
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
	
	public String checkBombListPos(int x, int y) {
		return bombList.checkPos(x, y);
	}
	
	public String checkUcmShip (int x, int y) {
		return ucm_Ship.checkPos(x, y);
	}
	
	public String checkUcmMissile (int x, int y) {
		String str = "";
		if(this.ucm_Missile != null) {
			str = ucm_Missile.checkPos(x, y);
		}
		return str;
	}
	
	public boolean missileExists() {
		return this.ucm_Missile != null;
	}
	
	///////////////////////////////////////////////////////////
	
	public boolean ucmShipIsCanShoot() {
		return ucm_Ship.isCanShoot();
	}

	public void ucmShipSetCanShoot(boolean canShoot) {
		ucm_Ship.setCanShoot(canShoot);
	}

	public int getDestroyerListNumOfDestroyers() {
		return this.destroyerList.getNumOfDestroyers();
	}

	public boolean destroyerCanShoot(int idx) {
		return destroyerList.destroyerCanShoot(idx);
	}

	public Destroyer getDestroyer(int idx) {
		return destroyerList.getDestroyer(idx);
	}

	public void newBomb(int posX, int posY, Destroyer destroyer) {
		bombList.newBomb(posX, posY, destroyer);
	}

	public int getNumOfValidBombs() {
		return bombList.getNumOfValidBombs();
	}

	public boolean bombOutOfBoard(int idx) {
		return bombList.bombOutOfBoard(idx);
	}

	public boolean outOfBoard() {
		return ucm_Missile.outOfBoard();
	}
	
	
	
	
}

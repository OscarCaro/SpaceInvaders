package tp.p1.model;

import tp.p1.model.gameElements.Destroyer;
import tp.p1.model.gameElements.UCM_Missile;
import tp.p1.model.gameElements.UCM_Ship;
import tp.p1.model.gameElements.Ufo;

public class Board {
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 9;
		
	private CarrierList carrierList;
	private DestroyerList destroyerList;
	private BombList bombList;
	private UCM_Ship ucm_Ship;
	private UCM_Missile ucm_Missile;
	private Ufo Ufo;
	
	
	public Board (Level diffLevel) {
		this.carrierList = new CarrierList(diffLevel);
		this.destroyerList = new DestroyerList(diffLevel);
		this.bombList = new BombList(diffLevel);	
		this.ucm_Ship = new UCM_Ship();
	}
	
	public void moveDownBombs() {
		for (int i = 0; i < this.getBombListNumOfValidBombs(); i++) {
			this.bombList.incrementBombPosY(i);
			//Check if out of board -> to destroy the object + destroyer.canShoot = true
			if(this.bombOutOfBoard(i)) {
				this.bombList.deleteBomb(this.bombList.getBombPosX(i), this.bombList.getBombPosY(i));
			}
			if (bombCheckCollitions(this.bombList.getBombPosX(i), this.bombList.getBombPosY(i))) {
				this.bombList.deleteBomb(this.bombList.getBombPosX(i), this.bombList.getBombPosY(i));
				deleteUcmMissile();
			}			
		}
	}
	
	public boolean bombCheckCollitions(int posX, int posY) {
		boolean coll = false;
		
		// collition with ucmShip -> decrement shield + remove bomb
		if (this.ucm_Ship.getPosX() == posX && this.ucm_Ship.getPosY() == posY) {
			this.ucm_Ship.decrementShield();
			coll = true;
		}
		
		// collition with ucmMissile -> remove missile + remove bomb
		if(missileExists()) {
			if ( this.ucm_Missile.getPosX() == posX && (this.ucm_Missile.getPosY() == posY || this.ucm_Missile.getPosY() == posY + 1) ) {
				//deleteUcmMissile();
				coll = true;
			}
		}		
		return coll;
	}
	
	public void launchMissile() {
		// 1. Move missile up
		this.ucm_Missile.moveUp();
		// 2. If out of Board -> remove missile
		if(this.UCM_missileOutOfBoard()) {
			deleteUcmMissile();
		}
		// 3. Collitions
		else if (missileCheckCollitions(this.ucm_Missile.getPosX(), this.ucm_Missile.getPosY())) {
			deleteUcmMissile();
		}
	}
	
	public boolean missileCheckCollitions(int posX, int posY) {
		boolean coll = false;
		
		// 1. If collition with destroyer -> decrement destroyer shield + remove missile
		if (missileCollidesDestroyer(posX,posY)) {
			coll = true;			
		}
		
		// 2. If collition with carrier -> decrement carrier shield + remove missile
		if (missileCollidesCarrier(posX, posY)) {
			coll = true;
		}
		
		// 3. If collision with bomb -> remove bomb + remove missile
		if (missileCollidesBomb(posX, posY)) {
			coll = true;
		}
		
		// 4. If collision with Ufo -> decrement shield + remove missile
		if (ufoExists()) {
			if (missileCollidesUfo(posX, posY)) {
				coll = true;
				this.ucm_Ship.setShock(true);
			}
		}		
		
		return coll;
	}
	
	public boolean missileCollidesDestroyer(int posX, int posY) {
		boolean collDest = false;
		
		for(int i = 0; i < this.getDestroyerListNumOfValidDestroyers(); i++) {
			if(this.destroyerList.getDestroyerPosX(i) == posX && this.destroyerList.getDestroyerPosY(i) == posY) {
				collDest = true;
				this.destroyerList.decrementDestroyerShield(i);				
			}
		}
		
		return collDest;
	}
	
	public boolean missileCollidesCarrier(int posX, int posY) {
		boolean collCarr = false;
		
		for(int i = 0; i < this.getCarrierListNumOfValidCarriers(); i++) {
			if(this.carrierList.getCarrierPosX(i) == posX && this.carrierList.getCarrierPosY(i) == posY) {
				collCarr = true;
				this.carrierList.decrementCarrierShield(i);				
			}
		}
		
		return collCarr;
	}
	
	public boolean missileCollidesBomb(int posX, int posY) {
		boolean collBomb = false;
		
		for(int i = 0; i < this.getBombListNumOfValidBombs(); i++) {
			if(this.bombList.getBombPosX(i) == posX && this.bombList.getBombPosY(i) == posY) {
				collBomb = true;
				this.bombList.deleteBomb(posX, posY);				
			}
		}
		
		return collBomb;
	}	
	
	public boolean missileCollidesUfo(int posX, int posY) {
		boolean collUfo = false;
		
		if (this.Ufo.getPosX() == posX && this.Ufo.getPosY() == posY) {
			this.Ufo.decrementShield();
			collUfo = true;
		}
		
		return collUfo;
	}	
	
	public void useShockwave() {
		// Iterate over all enemies to decrease their shields
		// 1. Carriers
		
		for (int i = 0; i < this.carrierList.getNumOfValidCarriers(); i++) {
			this.carrierList.decrementCarrierShield(i);
		}
		
		// 2. Destroyer
		for (int i = 0; i < this.destroyerList.getNumOfValidDestroyers(); i++) {
			this.destroyerList.decrementDestroyerShield(i);
		}
		
		this.ucm_Ship.setShock(false);
		
		// 3. Ufo shield is not decreased because it can lead to a permanent shockwave state
	
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
	
// <<<<<<<<<<  Delegate methods to: CARRIERLIST  >>>>>>>>>>>
	
	public void moveCarrierListLeft () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.carrierList.getNumOfValidCarriers(); i++) {
			this.carrierList.moveCarrierToLeft(i);
		}
	}
	
	public void moveCarrierListRight () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.carrierList.getNumOfValidCarriers(); i++) {
			this.carrierList.moveCarrierToRight(i);
		}
	}
	
	public void moveCarrierListDown () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.carrierList.getNumOfValidCarriers(); i++) {
			this.carrierList.moveCarrierDown(i);
		}
	}
	
	public String checkCarrierListPos(int x, int y) {
		return carrierList.checkPos(x, y);
	}

	public void carrierListDeleteCarrier(int posX, int posY) {
		this.carrierList.deleteCarrier(posX, posY);
	}
	
	public boolean checkCarriersInBottomRow() {
		return this.carrierList.carriersInBottomRow();
	}
	
	public int carrierListMinDistToLeftSide() {
		return this.carrierList.minDistToLeftSide();
	}
	
	public int carrierListMinDistToRightSide() {
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
	
	public int getCarrierListNumOfValidCarriers() {
		return this.carrierList.getNumOfValidCarriers();
	}
	
// <<<<<<<<<<  Delegate methods to: CARRIER  >>>>>>>>>>>
	
	public int carrierListGetCarrierPosX(int idx) {
		return this.carrierList.getCarrierPosX(idx);
	}
	
	public int carrierListGetCarrierPosY(int idx) {
		return this.carrierList.getCarrierPosY(idx);
	}
	
	public int carrierListgetCarrierScore(int idx) {
		return carrierList.getCarrierScore(idx);
	}
	
	public int carrierListgetCarrierShield(int idx) {
		return this.carrierList.getCarrierShield(idx);
	}	
	
// <<<<<<<<<<  Delegate methods to: DESTROYERLIST  >>>>>>>>>>>
	
	public void moveDestroyerListLeft () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.destroyerList.getNumOfValidDestroyers(); i++) {
			this.destroyerList.moveDestroyerToLeft(i);
		}
	}
	
	public void moveDestroyerListRight () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.destroyerList.getNumOfValidDestroyers(); i++) {
			this.destroyerList.moveDestroyerToRight(i);
		}
	}
	
	public void moveDestroyerListDown () {
		// All checks for errors done (in Game) before calling this function
		for (int i = 0; i < this.destroyerList.getNumOfValidDestroyers(); i++) {
			this.destroyerList.moveDestroyerDown(i);
		}
	}
	
	public void destroyerListDeleteDestroyer(int posX, int posY) { 
		this.destroyerList.deleteDestroyer(posX, posY);
	}
	
	public boolean checkDestroyersInBottomRow() {
		return this.destroyerList.destroyersInBottomRow();
	}
	
	public int destroyerListMinDistToLeftSide() {
		return this.destroyerList.minDistToLeftSide();
	}
	
	public int destroyerListMinDistToRightSide() {
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
	
	public String checkDestroyerListPos(int x, int y) {
		return destroyerList.checkPos(x, y);
	}
	
	public int getDestroyerListNumOfValidDestroyers() {
		return this.destroyerList.getNumOfValidDestroyers();
	}
	
	public Destroyer destroyerListGetDestroyer(int idx) {
		return destroyerList.getDestroyer(idx);
	}
	
// <<<<<<<<<<  Delegate methods to: DESTROYER  >>>>>>>>>>>
	
	public int destroyerListGetDestroyerPosX(int idx) {
		return this.destroyerList.getDestroyerPosX(idx);
	}
	
	public int destroyerListGetDestroyerPosY(int idx) {
		return this.destroyerList.getDestroyerPosY(idx);
	}

	public int destroyerListGetDestroyerScore(int idx) {
		return destroyerList.getDestroyerScore(idx);
	}
	
	public int destroyerListGetDestroyerShield(int idx) {
		return this.destroyerList.getDestroyerShield(idx);
	}	
	
	public boolean getDestroyerCanShoot(int idx) {
		return destroyerList.getDestroyerCanShoot(idx);
	}	

// <<<<<<<<<<  Delegate methods to: UCM_SHIP  >>>>>>>>>>>

	public String checkUcmShip (int x, int y) {
		return ucm_Ship.checkPos(x, y);
	}
	
	public boolean ucmShipIsCanShoot() {
		return ucm_Ship.isCanShoot();
	}

	public void ucmShipSetCanShoot(boolean canShoot) {
		ucm_Ship.setCanShoot(canShoot);
	}
	
	public boolean ucmHasShockwave() {
		return this.ucm_Ship.isShock();
	}
	
	public int getUcmShipShield() {
		return this.ucm_Ship.getShield();
	}
	
	public boolean getUcmShipIsShock() {
		return this.ucm_Ship.isShock();
	}

// <<<<<<<<<<  Delegate methods to: UCM_MISSILE  >>>>>>>>>>>

	public String checkUcmMissile (int x, int y) {
		String str = "";
		if(this.ucm_Missile != null) {
			str = ucm_Missile.checkPos(x, y);
		}
		return str;
	}
	
	public void deleteUcmMissile() {
		this.ucm_Ship.setCanShoot(true);
		this.ucm_Missile = null;
	}
	
	public void shootUcmMissile() {
		this.ucm_Missile = new UCM_Missile(this.ucm_Ship.getPosX(), this.ucm_Ship.getPosY());
		ucmShipSetCanShoot(false);
	}	
	
	public boolean missileExists() {
		return this.ucm_Missile != null;
	}
	
	public boolean UCM_missileOutOfBoard() {
		return ucm_Missile.outOfBoard();
	}
		
// <<<<<<<<<<  Delegate methods to: UFO  >>>>>>>>>>>

	public void createUfo() {
		this.Ufo = new Ufo();
	}
	
	public boolean ufoExists() {
		return (this.Ufo != null);
	}
	
	public void moveUfo() {
		this.Ufo.moveUfo();
		// Check out of Board
		if (this.Ufo.outOfBoard()) {
			this.Ufo = null;
		}
	}
	
	public String checkUfo(int x, int y) {		
		String str = "";
		if(ufoExists()) {
			str = this.Ufo.checkPos(x, y);
		}
		return str;
	}
	
	public int getUFOPoints() {
		return Ufo.getPoints();
	}

	public int getUFOShield() {
		return Ufo.getShield();
	}
	
// <<<<<<<<<<  Delegate methods to: BOMBLIST  >>>>>>>>>>>
	
	public String checkBombListPos(int x, int y) {
		return bombList.checkPos(x, y);
	}
	
	public void newBomb(int posX, int posY, Destroyer destroyer) {
		bombList.newBomb(posX, posY, destroyer);
	}

	public int getBombListNumOfValidBombs() {
		return bombList.getNumOfValidBombs();
	}

	public boolean bombOutOfBoard(int idx) {
		return bombList.bombOutOfBoard(idx);
	}

	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}

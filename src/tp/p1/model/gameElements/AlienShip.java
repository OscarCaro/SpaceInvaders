package tp.p1.model.gameElements;

import tp.p1.model.Direction;
import tp.p1.model.Game;

public abstract class AlienShip extends EnemyShip {
	protected static int alienCounter;
	
	protected static Direction moveDirection;
	protected static int numOfShipsMovedInTurn;			//set to 0 at every turn by Board.update()
	protected static boolean moveDownInNextTurn;		//set to false at beginning in BoardInitializer
	protected static boolean moveDownInThisTurn;		//set to false at beginning in BoardInitializer
	
	protected static boolean inBottomRow;				//set to false at beginning in BoardInitializer
	
	public AlienShip (int posX, int posY, Game game, int shield, int points, String initial) {
		super(posX, posY, game, shield, points, initial);
		incrementAlienCounter();
	}
	
	@Override
	public void move() {
		
		if (moveDownInNextTurn) {
			this.specificMove(moveDirection, 1);
			numOfShipsMovedInTurn++;
			
			if (numOfShipsMovedInTurn == alienCounter) {
				// Prepare the boolean for the beginning of next turn
				moveDownInNextTurn = false;
				moveDownInThisTurn = true;		
			}			
			
		}
		
		else if ( moveDownInThisTurn ) {
			this.specificMove(Direction.DOWN, 1);
			numOfShipsMovedInTurn++;
			
			if (numOfShipsMovedInTurn == alienCounter) {
				// Reset booleans to move normally on next turn (to the opposite dir)
				moveDownInThisTurn = false;
				moveDirection = Direction.oppositeOf(moveDirection);
			}
		}
		
		else {
			this.specificMove(moveDirection, 1);
			numOfShipsMovedInTurn++;
			
			if (this.isOnSide()) {
				// Set trigger to move down on next turn 
				moveDownInNextTurn = true;
			}
		}		
		
		if (this.isOnBottomRow()) {
			inBottomRow = true;
		}		
	}
	
	protected boolean isOnSide() {
		return (this.getPosX() == 0 || this.getPosX() == Game.COLUMNS - 1);
	}
	
	protected boolean isOnBottomRow() {
		return (this.getPosY() == Game.ROWS - 1);
	}
	
	public static void setMoveDirection(Direction moveDirection) {
		AlienShip.moveDirection = moveDirection;
	}
	
	public static void setInBottomRow(boolean inBottomRow) {
		AlienShip.inBottomRow = inBottomRow;
	}
	
	public static void setMoveDownInNextTurn(boolean moveDownInNextTurn) {
		AlienShip.moveDownInNextTurn = moveDownInNextTurn;
	}
	
	public static void setMoveDownInThisTurn(boolean moveDownInThisTurn) {
		AlienShip.moveDownInThisTurn = moveDownInThisTurn;
	}
	
	public static void resetNumOfShipsMovedInTurn() {
		AlienShip.numOfShipsMovedInTurn = 0;
	}
	
	@Override
	public boolean receiveShockWaveAttack(int damage) {
		this.decrementShield(damage);		
		return true;
	}
	
	public static boolean allDead() {		
		return (AlienShip.alienCounter <= 0);
	}

	public static boolean haveLanded() {
		return AlienShip.inBottomRow;
	}
	
	public static void resetAlienCounter() {
		AlienShip.alienCounter = 0;
	}
	
	protected static void incrementAlienCounter() {
		AlienShip.alienCounter++;
	}
	
	protected static void decrementAlienCounter() {
		AlienShip.alienCounter--;
	}
	
	public static int getAlienCounter() {
		return alienCounter;
	}
}

package tp.p1.model.gameElements;
import tp.p1.model.*;

public abstract class GameElements implements IAttack {	
	protected int posX;
	protected int posY;
	protected int shield;
	protected Game game;
	
	public GameElements(int posX,int posY,Game game, int shield) {
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		this.shield = shield;
	}
	
	public void move(Direction direction, int numOfCells) {
		this.posX += direction.getXmovement() * numOfCells;
		this.posY += direction.getYmovement() * numOfCells;
		// See Direction class for better explanation
	}
	
	public String checkPos (int x, int y) {
		String str = "";
		
		if (this instanceof Printable) {
			// Check if object's sub-class implements Printable interface
			// Because if not, method toString makes no sense
			
			if (isOnPosition(x, y)) {
				str = this.toString();
			}
		}		
		return str;
	}
	
	public boolean isOnPosition( int posX, int posY) {
		return ( this.posX == posX && this.posY == posY);
	}
	
	public boolean isOut() {
		return !game.isOnBoard(this.posX, this.posY);
	}
	
	public abstract void computerAction();
	public abstract void onDelete();
	// public abstract void move();				we did it in another way with general method move here
	// public abstract String toString();		we did it in another way with Interface Printable
	
	public int getShield() {
		return shield;
	}
	
	public void setShield(int shield) {
		this.shield = shield;
	}
	
	public void decrementShield(int amount) {
		this.shield -= amount;
	}
	
	public boolean isAlive() {
		return this.shield > 0;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}


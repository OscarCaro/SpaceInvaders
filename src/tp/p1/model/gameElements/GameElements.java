package tp.p1.model.gameElements;
import tp.p1.model.*;

public class GameElements {
	private int posX;
	private int posY;
	private Game game;
	
	public GameElements(int posX,int posY,Game game) {
		this.posX = posX;
		this.posY = posY;
		this.game = game;
	}
	
	public void move(Direction direction, int numOfCells) {
		this.posX += direction.getXmovement() * numOfCells;
		this.posY += direction.getYmovement() * numOfCells;
		// See Direction class for better explanation
	}
	
	public String checkPos (int x, int y) {
		String str = "";
		
		if (this instanceof Printable) {
			// Method toString only valid for sub-classes that implement Printable
			
			if (this.getPosX() == x && this.getPosY() == y) {
				str = this.toString();
			}
		}		
		return str;
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


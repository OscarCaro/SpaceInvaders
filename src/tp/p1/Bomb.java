package tp.p1;

public class Bomb {
	private boolean isEnemy;
	private int posX, posY;
		
	public Bomb(boolean isEnemy, int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.isEnemy = isEnemy;
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
		public String toString() {
			String sprite;
			if(this.isEnemy) {
				sprite = "!";
			}
			else {
				sprite = "^";
			}
			return sprite;
		}
}

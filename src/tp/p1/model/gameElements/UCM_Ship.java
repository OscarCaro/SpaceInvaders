package tp.p1.model.gameElements;

import tp.p1.model.Game;

public class UCM_Ship extends Ship implements Printable{
	
	private final String sprite = "/-^-\\";
	private boolean shock; 	
	private boolean canShoot;

	
	public UCM_Ship (Game game, int posX, int posY) {
		super(4, 7, game, 3);
		this.shock = false;
		this.canShoot = true;
	}
	
	public boolean isCanShoot() {
		return canShoot;
	}

	public void setCanShoot(boolean canShoot) {
		this.canShoot = canShoot;
	}
	
	public boolean isShock() {
		return shock;
	}
	
	public void setShock(boolean shock) {
		this.shock = shock;
	}
	
	public String toString() {
		return this.sprite;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
	
}

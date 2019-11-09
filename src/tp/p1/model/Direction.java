package tp.p1.model;

// Explanation: The two attributes x,y are used when dealing with movements.

// Example: If an object is told to move to the left (by passing argument LEFT to function move() ),
//			it will know that its posX should be decremented because LEFT.getXmovement returns -1.
//			And so it will know that its posY shouldn't be changed because LEFT.getYmovement returns 0.

public enum Direction {
	
	LEFT(-1, 0),
	RIGHT(1, 0),
	UP(0, -1),		// Attention: the highest row is 0, decrementing Y means going up
	DOWN(0, 1);	
	
	private int xMovement;
	private int yMovement;
	
	private Direction(int xMov, int yMov) {
		this.xMovement = xMov;
		this.yMovement = yMov;
	}
	
	public static Direction oppositeOf (Direction input) {
		Direction result;
		switch (input) {
			case LEFT:
				result = Direction.RIGHT;
				break;
			case RIGHT:
				result = Direction.LEFT;
				break;
			case UP:
				result = Direction.DOWN;
				break;	
			default:
				result = Direction.UP;
				break;
		}
		return result;
	}
	
	public int getXmovement() {
		return this.xMovement;
	}
	
	public int getYmovement() {
		return this.yMovement;
	}
}

package tp.p1;

public class Board {
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 9;
	
	private CellTypes[][] enumBoard;
	
	private CarrierList carrierList;
	private DestroyerList destroyerList;
	private BombList bombList;
	
	
	public Board (Level diffLevel) {
		this.carrierList = new CarrierList();
		this.destroyerList = new DestroyerList();
		this.bombList = new BombList();
		this.enumBoard = new CellTypes[ROWS][COLUMNS];
		initBoard(diffLevel);
	}
	
	private void initBoard(Level diffLevel) {
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				this.enumBoard[i][j] = CellTypes.EMPTY;
			}
		}
		
		// ToDo: populate according to difflevel (setting the posInLIst of each enum value) +
		// + create objects of carrierList, DestroyerList and BombList at the same time
		if (diffLevel == Level.EASY) {
			
		} 
		else if (diffLevel== Level.HARD) {
			
		}
		else if (diffLevel == Level.INSANE) {
			
		}
		
	}
}

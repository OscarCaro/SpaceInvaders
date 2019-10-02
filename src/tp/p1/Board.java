package tp.p1;

public class Board {
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 9;
	
	private CellTypes[][] enumBoard;
	
	private CarrierList carrierList;
	private DestroyerList destroyerList;
	private BombList bombList;
	
	
	public Board (Level diffLevel) {
		initBoard(diffLevel);
		this.enumBoard = new CellTypes[ROWS][COLUMNS];
		this.carrierList = new CarrierList(diffLevel, enumBoard);
		this.destroyerList = new DestroyerList(diffLevel, enumBoard);
		this.bombList = new BombList();	
	}
	
	private void initBoard(Level diffLevel) {
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				this.enumBoard[i][j] = CellTypes.EMPTY;
			}
		}
		
		// ToDo: create ucmShip
	}
	
	public void fillEnumBoardPosition(CellTypes type, int posX, int posY, int posInList) {
		if ( (posX >= 0 && posX < COLUMNS) && (posY >= 0 && posY < ROWS) ) {
			enumBoard[posX][posY] = type;
			enumBoard[posX][posY].setPosInList(posInList);
		}
	}
}

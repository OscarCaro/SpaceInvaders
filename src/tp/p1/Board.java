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
		this.carrierList = new CarrierList(this, diffLevel, enumBoard);
		this.destroyerList = new DestroyerList(this, diffLevel, enumBoard);
		this.bombList = new BombList();	
	}
	
	public String checkCarrierListPos(int x, int y) {
		return carrierList.checkPos(x, y);
	}

	public String checkDestroyerListPos(int x, int y) {
		return destroyerList.checkPos(x, y);
	}

	private void initBoard(Level diffLevel) {
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				this.enumBoard[i][j] = CellTypes.EMPTY;
			}
		}
		
		this.enumBoard[7][4] = CellTypes.UCM_SHIP; //UCM_Ship Created
	}
	
	public void fillEnumBoardPosition(CellTypes type, int posX, int posY, int posInList) {
		if ( (posX >= 0 && posX < COLUMNS) && (posY >= 0 && posY < ROWS) ) {
			enumBoard[posX][posY] = type;
			enumBoard[posX][posY].setPosInList(posInList);
		}
	}
}

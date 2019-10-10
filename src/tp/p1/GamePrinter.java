package tp.p1;

public class GamePrinter {
	
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	
	public GamePrinter (int rows, int cols) {
		this.numRows = rows;	// 8
		this.numCols = cols;	// 9	
	}
	
	private void encodeGame(Game game) {
		board = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				board[i][j] = game.checkPos(j, i);				
			}
		}
	}
	
	public String toString(Game game) {

		encodeGame(game);
		
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;
		
		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);
		
		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;
		
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
			str.append(margin).append(vDelimiter);
			for (int j=0; j<numCols; j++)
				str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
			if (i != numRows - 1) str.append(lineDelimiter);
			else str.append(lineEdge);	
		}
		
		return str.toString();
	}
}

[1mdiff --git a/bin/tp/p1/GamePrinter.class b/bin/tp/p1/GamePrinter.class[m
[1mindex af07be3..de16073 100644[m
Binary files a/bin/tp/p1/GamePrinter.class and b/bin/tp/p1/GamePrinter.class differ
[1mdiff --git a/src/tp/p1/GamePrinter.java b/src/tp/p1/GamePrinter.java[m
[1mindex c3525d4..5e40754 100644[m
[1m--- a/src/tp/p1/GamePrinter.java[m
[1m+++ b/src/tp/p1/GamePrinter.java[m
[36m@@ -9,16 +9,15 @@[m [mpublic class GamePrinter {[m
 	[m
 	[m
 	public GamePrinter (int rows, int cols) {[m
[31m-		this.numRows = rows;[m
[31m-		this.numCols = cols;		[m
[31m-		//encodeGame(game);[m
[32m+[m		[32mthis.numRows = rows;	// 8[m
[32m+[m		[32mthis.numCols = cols;	// 9[m[41m	[m
 	}[m
 	[m
 	private void encodeGame(Game game) {[m
 		board = new String[numRows][numCols];[m
 		for(int i = 0; i < numRows; i++) {[m
 			for(int j = 0; j < numCols; j++) {[m
[31m-				board[i][j] = game.checkPos(i, j);				[m
[32m+[m				[32mboard[i][j] = game.checkPos(j, i);[m[41m				[m
 			}[m
 		}[m
 	}[m

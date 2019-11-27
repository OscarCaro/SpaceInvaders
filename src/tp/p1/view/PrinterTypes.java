package tp.p1.view;

import tp.p1.model.Game;

public enum PrinterTypes {
	BOARDPRINTER ("boardprinter",
			"prints the game formatted as a board of dimension: ",
			new BoardPrinter()),
	STRINGIFIER("stringifier",
			"prints the game as plain text",
			new Stringifier());
	
	private String printerName;			
	private String helpText;
	private GamePrinter printerObject;
	
	private PrinterTypes(String name, String text, GamePrinter printer) {
		printerName = name;
		helpText = text;
		printerObject = printer;
	}
	
	public static String printerHelp(Game game) {
		String helpString ="";
		for(PrinterTypes printer : PrinterTypes.values()) {
			helpString += String.format("%s : %s%s%n", printer.printerName, printer.helpText,
					(printer == BOARDPRINTER ? Game.ROWS +" x "+ Game.COLUMNS : "") );
		}
		return helpString;
	}
	// Assumes a max of one object of each printer type is needed (otherwise return a copy)
	public GamePrinter getObject(Game game) {
		printerObject.setGame(game);
		return printerObject;
	}
	
}
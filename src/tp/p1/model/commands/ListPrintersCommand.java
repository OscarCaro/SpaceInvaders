package tp.p1.model.commands;

import tp.p1.model.Game;
import tp.p1.view.PrinterTypes;

public class ListPrintersCommand extends NoParamsCommand{
	
	public ListPrintersCommand() {
		super("listPrinters", "lp", "List Printers", "prints a list of available printers");
	}
	
	@Override
	public boolean execute(Game game) {
		System.out.println(PrinterTypes.printerHelp(game));
		return false;
	}
}

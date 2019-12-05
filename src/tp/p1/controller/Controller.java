
package tp.p1.controller;
import tp.p1.model.commands.*;
import tp.p1.model.exceptions.CommandParseException;
import tp.p1.model.exceptions.UnknownCommandException;
import tp.p1.model.exceptions.commandExecuteExceptions.CommandExecuteException;
import tp.p1.model.utils.*;
import tp.p1.view.GamePrinter;
import tp.p1.view.PrinterTypes;
import tp.p1.model.Game;
import tp.p1.model.Level;

import java.util.Random;
import java.util.Scanner;


public class Controller {
	
	private Game game;
	private Scanner in;
	private GamePrinter printer;
	
	public Controller (Level diffLevel, Random random) {
		in = new Scanner(System.in);
		game = new Game(diffLevel, random);
		this.printer = PrinterTypes.BOARDPRINTER.getObject(game);
	}
	
	public boolean run () {
		System.out.println(this.printer);

		while (!game.isFinished()){
			
			System.out.println("Command > ");
			String[] words = in.nextLine().toLowerCase().trim().split ("\\s+");
			
			try {
				Command command = CommandGenerator.parseCommand(words);				
				//Null command checked (with exception) in the parse function
				if (command.execute(game)) {
					this.game.update();						
					System.out.println(this.printer);
				}
				
			} catch (CommandParseException | CommandExecuteException | NumberFormatException | UnknownCommandException e) {
				System.err.format(e.getMessage() + "%n%n");
			}			
		}
		
		return playAgain();
	}
	
	private boolean playAgain() {
		System.out.println("Play again [y/n]: ");
		String input = in.nextLine().toLowerCase().trim();		
		return (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes"));
	}

}

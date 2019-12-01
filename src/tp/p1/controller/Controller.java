
package tp.p1.controller;
import tp.p1.model.commands.*;
import tp.p1.model.exceptions.CommandParseException;
import tp.p1.model.exceptions.commandExecuteExceptions.CommandExecuteException;
import tp.p1.model.utils.*;
import tp.p1.view.GamePrinter;
import tp.p1.view.PrinterTypes;

import java.util.Random;
import java.util.Scanner;

import tp.p1.model.Game;
import tp.p1.model.Level;

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
				if (command != null) {
					if (command.execute(game)) {
						this.game.update();						
						System.out.println(this.printer);
					}
				}
				else {
					System.out.format("Unknown command");
				}
			} catch (CommandParseException | CommandExecuteException | NumberFormatException e) {
				System.err.format(e.getMessage() + "%n%n");
				e.printStackTrace();
			}			
		}
		
		return playAgain();
	}
	
	private boolean playAgain() {
		System.out.println("Play again [y/n]: ");
		String input = in.nextLine().toLowerCase().trim();		
		return (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes"));
	}
	
//	public void run () {
//		boolean continueGame = false;
//		
//		printInfo();
//		System.out.println(game);	
//		continueGame = handleCommand();
//
//		while (continueGame) {			
//			this.game.computerAction();
//			this.game.update();
//			this.game.incrementCycleCounter();
//			
//			printInfo();
//			System.out.println(game);	
//			continueGame = handleCommand();
//			
//			if(this.game.checkEnemiesInBottomRow() || this.game.checkUCMdead()) {
//				continueGame = false;
//				System.out.println("Game Over, Aliens win");
//			}
//			
//			if(this.game.getNumOfValidAliens() == 0) {
//				continueGame = false;
//				System.out.println("You win!!!");
//			}
//			
//		} 
//		// Todo: ask if user wants to play again or exit app
//	}
//	
//	public boolean handleCommand() {
//		String input;
//		System.out.println("Command > ");
//		input = in.nextLine();
//		return processInput(input);
//	}
//
//	public boolean processInput(String input) {
//		boolean continueGame = true;
//		
//		input = input.toLowerCase();	
//			
//		if (input.equals("move left 1") || input.equals("m left 1")) {	
//			this.game.moveUcmShip(true, false, 1);			
//		} 
//		else if (input.equals("move left 2") || input.equals("m left 2")) {	
//			this.game.moveUcmShip(true, false, 2);
//		}
//		else if (input.equals("move right 1") || input.equals("m right 1")) {
//			this.game.moveUcmShip(false, true, 1);
//		}
//		else if (input.equals("move right 2") || input.equals("m right 2")) {
//			this.game.moveUcmShip(false, true, 2);
//		}	
//		else if (input.equals("shoot") || input.equals("s")) {
//			if (this.game.ucmShipIsCanShoot()) {
//				this.game.shootUcmMissile();
//				
//				// Set missile + isCanShoot false
//			}
//			else {
//				System.out.println("Error: A missile is already fired");
//				continueGame = handleCommand();		// Be careful -> recursion to ask input again
//			}			
//		}
//		else if (input.equals("none") || input.equals("n") || input.equals("")) {
//			
//		}		
		
//		else if (input.equals("shockwave") || input.equals("w")) {
//			
//			if (this.game.useShockwave()) {		//THis also decrements enemy shields
//				this.game.checkDeadEnemies();
//			}
//			else {
//				System.out.println("No shockwave available");
//				continueGame = handleCommand();
//			}
//		}	
		
//		else if (input.equals("list") || input.equals("l")) {
//			printList();
//			continueGame = handleCommand();		// Be careful -> recursion to ask input again
//		}		
//		else if (input.equals("reset") || input.equals( "r")) {
//			continueGame = false;
//		}		
//		else if (input.equals( "help") ||input.equals("h")) {
//			printHelp();
//			continueGame = handleCommand();		// Be careful -> recursion to ask input again
//		}		
//		else if (input.equals("exit") || input.equals("e")) {
//			continueGame = false;
//			System.out.println("Game over");
//			System.out.println("Player exit");
//		}		
//		else {
//			System.out.println("Wrong input. Try again");
//			continueGame = handleCommand();		// Be careful -> recursion to ask input again
//		}
//		
//		return continueGame;
//	}
			

	
//	private void printHelp() {
//		System.out.println("move <left|right><1|2>: causes the UCM-Ship to move as indicated.");
//		System.out.println("shoot: causes the UCM-Ship to launch a missile.");
//		System.out.println("shockwave: causes the UCM-Ship to release a shock wave.");
//		System.out.println("list: displays the list of ship types in the game.");
//		System.out.println("reset: starts a new game.");
//		System.out.println("help: prints this help message.");
//		System.out.println("exit: terminates the program.");
//		System.out.println("[none]: skips one cycle.");
//	}
	
//	private void printList() {
//		System.out.println("-<x>-: Points: 5 - Damage: 0 - Resistence: 2");
//		System.out.println("!<x>!: Points: 10 - Damage: 1 - Resistence: 1");
//		System.out.println("<(+)>: Points: 25 - Damage: 0 - Resistence: 1");
//		System.out.println("/-^-\\: Damage: 1 - Resistence: 3");
//	}
}

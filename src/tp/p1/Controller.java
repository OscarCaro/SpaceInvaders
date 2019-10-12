
package tp.p1;
import java.util.Scanner;

public class Controller {
	
	private Game game;
	private Scanner in;
	
	public Controller (Level diffLevel, int randomValue) {
		in = new Scanner(System.in);
		game = new Game(diffLevel, randomValue);
	}
	
	public void run () {
		String input;
		
		printInfo();
		System.out.println(game);	// calling game.toString()
		System.out.println("Command > ");
		input = in.nextLine();
		processInput(input);
		while(!input.equals("exit") || !input.equals("e")) {
			printInfo();
			System.out.println(game);	// calling game.toString()
			System.out.println("Command > ");
			input = in.nextLine();
			processInput(input);
		}
		
	}
	
	public void printInfo() {
		System.out.println("Score: " + this.game.getScore());
		System.out.println("Shield Strength: " + this.game.getUcmShipShield());
		String hasShock; 
		if (this.game.getUcmShipIsShock()) {
			hasShock = "Yes";
		} else {
			hasShock = "No";
		}
		System.out.println("Shockwave: " + hasShock);
		System.out.println("Cycle number: " + this.game.getCycleCounter());
		System.out.println("Remaining alien ships: " + this.game.getNumOfAliens());
	}

	public void processInput(String input) {
		
		input = input.toLowerCase();	
			
			if (input.equals("move left 1") || input.equals("m left 1")) {	
				this.game.moveUcmShip(true, false, 1);
		
			} 
			else if (input.equals("move left 2") || input.equals("m left 2")) {	
				this.game.moveUcmShip(true, false, 2);
			
			}
			else if (input.equals("move right 1") || input.equals("m right 1")) {
				this.game.moveUcmShip(false, true, 1);

			}
			else if (input.equals("move right 2") || input.equals("m right 2")) {
				this.game.moveUcmShip(false, true, 2);

			}
		
			else if (input.equals("shoot") || input.equals("s")) {
			
			}

			else if (input.equals("none") || input.equals("n") || input.equals("")) {
			
			}
			
			else if (input.equals("list") || input.equals("l")) {
				System.out.println("-<x>-: Points: 5 - Damage: 0 - Resistence: 2");
				System.out.println("!<x>!: Points: 10 - Damage: 1 - Resistence: 1");
				System.out.println("<(+)>: Points: 25 - Damage: 0 - Resistence: 1");
				System.out.println("/-^-\\: Damage: 1 - Resistence: 3");
			}
			
			else if (input.equals("reset") || input.equals( "r")) {
			
			}
			
			else if (input.equals( "help") ||input.equals("h")) {
				System.out.println("move <left|right><1|2>: causes the UCM-Ship to move as indicated.");
				System.out.println("shoot: causes the UCM-Ship to launch a missile.");
				System.out.println("shockwave: causes the UCM-Ship to release a shock wave.");
				System.out.println("list: displays the list of ship types in the game.");
				System.out.println("reset: starts a new game.");
				System.out.println("help: prints this help message.");
				System.out.println("exit: terminates the program.");
				System.out.println("[none]: skips one cycle.");
			}
			
			else if (input.equals("exit") || input.equals("e")) {
			
			}
			
			else {
			// Error Message to ask again for input
			}
			
			System.out.println(game); 
		}
	}		
	

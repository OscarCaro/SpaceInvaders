
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
		
		while(!input.equals("exit") || !input.equals("e")) {
				this.run();
			
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
			
			}
			
			else if (input.equals("reset") || input.equals( "r")) {
			
			}
			
			else if (input.equals( "help") ||input.equals("h")) {
			
			}
			
			else if (input.equals("exit") || input.equals("e")) {
			
			}
			
			else {
			// Error Message to ask again for input
			}
			
			System.out.println(game); 
		}
	}		
	
}

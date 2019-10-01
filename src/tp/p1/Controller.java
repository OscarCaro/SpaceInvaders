
package tp.p1;
import java.util.Scanner;

public class Controller {

	public void processInput(String input) {
		// This function assumes that the String input is already taken from the CMD
		
		int positionx = 4;
		int positiony = 7;
		
		UCM_Ship player = new UCM_Ship(positionx,positiony);
		
		input = input.toLowerCase();	
		
		if (input == "move left 1" || input == "m left 1") {
			positionx = positionx -1;
		} 
		else if (input == "move left 2" || input == "m left 2") {
			positionx = positionx -2;
		}
		else if (input == "move right 1" || input == "m right 1") {
			positionx = positionx +1;
		}
		else if (input == "move right 2" || input == "m right 2") {
			positionx = positionx +2;
		}
		else if (input == "shoot" || input == "s") {
			
		}
		else if (input == "shockwave" || input == "w") {
			if(player.shock == true) {
				
			}
			
			else {
				System.out.println("Shockwave not available!!");
			}
		}
		else if (input == "none" || input == "n" || input == "") {
			
		}
		else if (input == "list" || input == "l") {
			
		}
		else if (input == "reset" || input == "r") {
			
		}
		else if (input == "help" || input == "h") {
			
		}
		else if (input == "exit" || input == "e") {
			
		}
		else {
			// Error Message to ask again for input
		}
		
	}		
	
}

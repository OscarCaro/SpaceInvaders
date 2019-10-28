package tp.p1.model.utils;
import tp.p1.controller.*;
import tp.p1.model.*;
public class CommandGenerator {
	
	private static Command[] availableCommands = {		// Todo: correct arguments
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new ShootCommand(),
			new UpdateCommand(),
			new MoveCommand(),
			new ShockwaveCommand()
	};
	
	public static Command parseCommand(String[] commandWords, Controller controller) {
		Command aux;
		Command result;
		for (Command cmd : availableCommands) {
			aux = cmd.parse(commandWords);
			if (aux != null) {
				result = aux;
			}
		}
		return result;
	}
	
	public static String commandHelp() {
		String helpText = "";
		for (Command cmd : availableCommands) {
			helpText += cmd.helpText();
		}
		return helpText;
	}

}

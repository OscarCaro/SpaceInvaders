package tp.p1.model.utils;

import tp.p1.model.commands.*;
import tp.p1.model.exceptions.CommandParseException;
import tp.p1.model.exceptions.UnknownCommandException;

public class CommandGenerator {
	
	private static Command[] availableCommands = {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new ShootCommand(),
			new MoveCommand(),
			new ShockwaveCommand(),
			new NoneCommand(),
			new BuyCommand(),
			new StringifyCommand(),
			new ListPrintersCommand(),
			new SaveCommand()
			};
	
	public static Command parseCommand(String[] commandWords) throws CommandParseException, UnknownCommandException{
		Command aux;
		Command result = null;
		for (Command cmd : availableCommands) {
			aux = cmd.parse(commandWords);
			if (aux != null) {
				result = aux;
			}
		}
		if (result == null) {
			throw new UnknownCommandException();
		}
		return result;
	}
	
	public static String commandHelp() {
		String helpText = "";
		for (Command cmd : availableCommands) {
			helpText += cmd.helpText() + System.lineSeparator();
		}
		return helpText;
	}

}

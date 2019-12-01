package tp.p1.model.commands;

import tp.p1.model.Game;
import tp.p1.model.exceptions.CommandExecuteException;
import tp.p1.model.exceptions.CommandParseException;

public abstract class Command {
	protected final String name;
	protected final String shortName;
	private final String commandText;
	private final String helpText;
	protected static final String incorrectNumArgsMsg ="Incorrect number of arguments";
	protected static final String incorrectArgsMsg ="Incorrect argument format";
	
	public Command(String name, String shortName, String commandText, String helpText){
		this.name = name;
		this.shortName = shortName;
		this.commandText = commandText; 
		this.helpText = helpText;
	}
	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	public abstract Command parse (String[] commandWords) throws CommandParseException;
	
	protected boolean matchCommandName(String inputText) {
		return this.shortName.equalsIgnoreCase(inputText) || this.name.equalsIgnoreCase(inputText);
	}
	
	public String helpText(){
		return String.format("%s : %s%n", commandText, helpText);
	}
	
	
}
package tp.p1.model.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import tp.p1.model.Game;
import tp.p1.model.exceptions.CommandParseException;
import tp.p1.view.PrinterTypes;

public class SaveCommand extends Command{
	
	public static final String CORRECT_FORMAT = "Usage: save filename";

	private String fileName;

	public SaveCommand() {
		super("save", "sv", "Save", "saves the current state of the game to a file");
	}
	
	public SaveCommand(String fileName) {
		super("save", "sv", "Save", "saves the current state of the game to a file");
		this.fileName = fileName;
	}

	@Override
	public boolean execute(Game game){
		try (BufferedWriter bw = new BufferedWriter( new FileWriter(fileName)) ){
			bw.write(PrinterTypes.STRINGIFIER.getObject(game).toString());
			System.out.println("Game succesfully saved in file " + fileName 
					+ ". Use the load command to reload it");
			
		} catch (IOException e) {
			System.err.print(e);
		}
		
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command save = null;
		if(commandWords.length > 0 && matchCommandName(commandWords[0])) {
			if(commandWords.length == 2) {
				save = new SaveCommand(commandWords[1] + ".dat");
			}
			else {
				throw new CommandParseException(CommandParseException.WRONGNUMOFARGS 
						+ ". " + CORRECT_FORMAT);
			}
			
		}		
		return save;
	}

}

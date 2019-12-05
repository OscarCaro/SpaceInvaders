package tp.p1.model.exceptions;

public class UnknownCommandException extends Exception{
	public static final String MESSAGE = "Unknown command";
	
	public UnknownCommandException() {
		super(MESSAGE);
	}

	public UnknownCommandException(String message){
		super(message); 
	}
	public UnknownCommandException(String message, Throwable cause){
		super(message, cause);
	}
	public UnknownCommandException(Throwable cause){
		super(cause); 
	}
	public UnknownCommandException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace){		
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

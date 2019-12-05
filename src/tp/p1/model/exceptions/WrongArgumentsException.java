package tp.p1.model.exceptions;

public class WrongArgumentsException extends Exception {
	public static final String MESSAGE = "Wrong arguments";
	
	public WrongArgumentsException() {
		super(MESSAGE);
	}

	public WrongArgumentsException(String message){
		super(message); 
	}
	public WrongArgumentsException(String message, Throwable cause){
		super(message, cause);
	}
	public WrongArgumentsException(Throwable cause){
		super(cause); 
	}
	public WrongArgumentsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace){		
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

package tp.p1.model.exceptions;

public class FileContentsException extends Exception{
	
	public FileContentsException() {
		super(); 
	}
	public FileContentsException(String message){
		super(message); 
	}
	public FileContentsException(String message, Throwable cause){
		super(message, cause);
	}
	public FileContentsException(Throwable cause){
		super(cause); 
	}
	public FileContentsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace){		
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

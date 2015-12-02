package kr.ac.mju.exception;

public class InputDataNotValidException extends Exception
{
	
	public InputDataNotValidException(String msg) {
		super(msg);
	}
	
	public InputDataNotValidException(Throwable cause) {
		super(cause);
	}
	
	public InputDataNotValidException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}

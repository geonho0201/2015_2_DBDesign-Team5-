package kr.ac.mju.exception;

public class InputDataRedundantException extends Exception
{
	
	private static final long serialVersionUID = -3271108764066389197L;
	
	public InputDataRedundantException(String msg) {
		super(msg);
	}
	
	public InputDataRedundantException(Throwable cause) {
		super(cause);
	}
	
	public InputDataRedundantException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}

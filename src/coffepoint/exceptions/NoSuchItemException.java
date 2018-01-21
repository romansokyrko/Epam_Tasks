package coffepoint.exceptions;

public class NoSuchItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchItemException() {
		super();
	}
	
	public NoSuchItemException(String message) {
		super(message);
	}

}

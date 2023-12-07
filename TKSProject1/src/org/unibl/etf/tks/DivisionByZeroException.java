package org.unibl.etf.tks;

/**
 * Custom exception class for division by zero situations.
 */
public class DivisionByZeroException extends Exception {
	
	/** The serial version UID. */
	private static final long serialVersionUID = 1L;

	
	 /**
     * Default constructor for DivisionByZeroException.
     * Constructs an instance of the exception with a predefined message.
     */
	public DivisionByZeroException() {
		super("Division by zero!");
	}

}

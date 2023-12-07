package org.unibl.etf.tks;

/**
 * Custom exception class for situations where a number is not in the expected range.
 */
public class NumberNotInAreaException extends Exception {
	
	/** The serial version UID. */
	private static final long serialVersionUID = 1L;

	 /**
     * Default constructor for NumberNotInAreaException.
     * Constructs an instance of the exception with a predefined message.
     */
	public NumberNotInAreaException() {
		super("Number not in area!");
	}
}

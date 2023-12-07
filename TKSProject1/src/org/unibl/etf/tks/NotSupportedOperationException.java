package org.unibl.etf.tks;

/**
 * Custom exception class for situations where an operation is not supported.
 */
public class NotSupportedOperationException extends Exception {
	
	 /** The serial version UID. */
	private static final long serialVersionUID = 1L;

	
	/**
     * Default constructor for NotSupportedOperationException.
     * Constructs an instance of the exception with a predefined message.
     */
	public NotSupportedOperationException() {
		super("Not supported operation!");
	}

}

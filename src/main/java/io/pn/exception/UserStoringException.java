package io.pn.exception;

public class UserStoringException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserStoringException() {
		super();
	}

	public UserStoringException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserStoringException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserStoringException(String message) {
		super(message);
	}

	public UserStoringException(Throwable cause) {
		super(cause);
	}

	
}

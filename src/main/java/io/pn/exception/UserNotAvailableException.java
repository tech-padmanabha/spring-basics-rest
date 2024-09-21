package io.pn.exception;

public class UserNotAvailableException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotAvailableException() {
		super();
	}

	public UserNotAvailableException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotAvailableException(String message) {
		super(message);
	}

	public UserNotAvailableException(Throwable cause) {
		super(cause);
	}

	
}

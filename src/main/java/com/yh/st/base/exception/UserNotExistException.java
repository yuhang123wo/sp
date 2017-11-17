package com.yh.st.base.exception;

public class UserNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6932320891588794024L;

	public UserNotExistException() {
		super();
	}

	public UserNotExistException(String string) {
		super(string);
	}
}

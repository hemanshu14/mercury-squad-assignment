package com.assignment.usermanagement.exceptions;

public class BaseException extends Exception {

	private static final long serialVersionUID = 6451603533119146117L;

	private String errorCode;

	public BaseException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
}

package com.assignment.usermanagement.exceptions;

import lombok.Getter;

/**
 * 
 * Exception class when there is no user available
 * 
 * @author hemanshu.banga
 *
 */

@Getter
public class UserNotFoundException extends BaseException {

	private static final long serialVersionUID = 6688328611441043098L;
	
	private String exceptionMessage;

	public UserNotFoundException(String errorCode, String exceptionMessage) {
		super(errorCode, exceptionMessage);
		this.exceptionMessage = exceptionMessage;
	}

}

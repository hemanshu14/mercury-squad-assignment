package com.assignment.usermanagement.exceptions;

import lombok.Data;

/**
 * 
 * Error class to send the error code and error message
 * 
 * @author hemanshu.banga
 *
 */

@Data
public class ErrorObject {

	private String errorCode;
	private String errorMessage;
	
	public ErrorObject(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}

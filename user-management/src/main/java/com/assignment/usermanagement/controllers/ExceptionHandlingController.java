package com.assignment.usermanagement.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.usermanagement.constants.Constants;
import com.assignment.usermanagement.exceptions.ErrorObject;
import com.assignment.usermanagement.exceptions.UserNotFoundException;

/**
 * 
 * Exception handler class wi=hich handles all the exceptions
 * 
 * @author hemanshu.banga
 *
 */

@ControllerAdvice
public class ExceptionHandlingController {

	/**
	 * Method to handle user not found exception
	 * 
	 * @param userNotFoundException exception that user is not found
	 * @return response entity with not found error code and error object
	 */
	@ExceptionHandler(value = { UserNotFoundException.class })
	public ResponseEntity<ErrorObject> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
		ErrorObject errorObject = new ErrorObject(userNotFoundException.getErrorCode(),
				userNotFoundException.getExceptionMessage());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 * Method to handle method argument not valid exception
	 * 
	 * @param validateException exception that method argument is not valid
	 * @return response entity with bad request error code and error object
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorObject> handleValidationExceptions(MethodArgumentNotValidException validateException) {
		ErrorObject errorObject = new ErrorObject(Constants.BAD_REQUEST_ERROR_CODE,
				validateException.getBindingResult().getFieldErrors().stream().findFirst().get().getDefaultMessage());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
	}

}

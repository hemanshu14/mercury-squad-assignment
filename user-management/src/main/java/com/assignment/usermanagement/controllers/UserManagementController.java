package com.assignment.usermanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.usermanagement.exceptions.UserNotFoundException;
import com.assignment.usermanagement.model.User;
import com.assignment.usermanagement.services.UserService;

/**
 * 
 * Controller to get all the user details
 * 
 * @author hemanshu.banga
 *
 */
@RestController
@RequestMapping("/users")
public class UserManagementController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * Method to retrieve the user details from the service with the provided first
	 * name and last name
	 * 
	 * @param firstName first name of the user
	 * @param lastName  last name of the user
	 * @return {@link ResponseEntity<User>} user details
	 * @throws UserNotFoundException
	 */
	@GetMapping
	public ResponseEntity<User> getUserDataWithParams(
			@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName) throws UserNotFoundException {
		return new ResponseEntity<User>(userService.getUserDataWithParams(firstName, lastName), HttpStatus.OK);
	}

	/**
	 * 
	 * Method to retrieve details of all the users
	 * 
	 * @return {@link ResponseEntity<List<User>} list of all the user's details
	 * @throws UserNotFoundException
	 */
	@GetMapping(path = "all")
	public ResponseEntity<List<User>> getUsersData() throws UserNotFoundException {
		return new ResponseEntity<List<User>>(userService.getUsersData(), HttpStatus.OK);
	}
}

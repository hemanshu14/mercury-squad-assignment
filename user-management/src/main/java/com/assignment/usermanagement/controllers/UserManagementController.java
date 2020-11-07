package com.assignment.usermanagement.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	 * @param firstName optional first name of the user
	 * @param lastName  optional last name of the user
	 * @return {@link ResponseEntity<List<User>>} list of the user details
	 * @throws UserNotFoundException
	 */
	@GetMapping
	public ResponseEntity<List<User>> getUsersData(@RequestParam("firstName") Optional<String> firstName,
			@RequestParam("lastName") Optional<String> lastName) throws UserNotFoundException {

		if (!firstName.isPresent() && !lastName.isPresent()) {
			return ResponseEntity.ok(userService.getUsersData());
		} else {
			List<User> users = new ArrayList<>();
			users.add(userService.getUserDataWithParams(firstName, lastName));
			return ResponseEntity.ok(users);
		}
	}
}

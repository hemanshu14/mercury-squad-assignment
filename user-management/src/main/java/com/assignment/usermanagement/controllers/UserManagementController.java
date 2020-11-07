package com.assignment.usermanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);

	/**
	 * 
	 * Method to get the user details from the service
	 * 
	 * @param firstName first name of the user
	 * @param lastName last name of the user
	 * @return the list of the user details
	 * @throws UserNotFoundException 
	 */
	@GetMapping
	public List<User> getUserData(@RequestParam("firstName") Optional<String> firstName, @RequestParam("lastName") Optional<String> lastName) throws UserNotFoundException {
		
		if(!firstName.isPresent() && !lastName.isPresent()) {
			return userService.getUsersData();
		}
		else {
			return userService.getUserDataWithParams(firstName, lastName);
		}
	}
}

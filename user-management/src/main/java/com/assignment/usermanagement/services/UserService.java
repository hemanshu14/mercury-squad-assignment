package com.assignment.usermanagement.services;

import java.util.List;
import java.util.Optional;

import com.assignment.usermanagement.exceptions.UserNotFoundException;
import com.assignment.usermanagement.model.User;

/**
 * Interface to retrieve the user details
 * 
 * @author hemanshu.banga
 *
 */
public interface UserService {

	/**
	 * Method to fetch user details with the first name and last name
	 * 
	 * @param firstName first name of the user
	 * @param lastName last name of the user
	 * @return list of user details matching with the first name and last name
	 * @throws UserNotFoundException 
	 */
	public List<User> getUserDataWithParams(Optional<String> firstName, Optional<String> lastName) throws UserNotFoundException;
	
	
	/**
	 * 
	 * Method to retrieve details of all the users
	 * 
	 * @return list of all the users details
	 * @throws UserNotFoundException
	 */
	public List<User> getUsersData() throws UserNotFoundException;
}
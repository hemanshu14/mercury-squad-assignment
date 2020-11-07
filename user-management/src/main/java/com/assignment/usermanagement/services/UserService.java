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
	 * @param firstName optional first name of the user
	 * @param lastName optional last name of the user
	 * @return  user details matching with the first name and last name
	 * @throws UserNotFoundException 
	 */
	public User getUserDataWithParams(Optional<String> firstName, Optional<String> lastName) throws UserNotFoundException;
	
	
	/**
	 * 
	 * Method to retrieve details of all the users
	 * 
	 * @return list of all the users details
	 * @throws UserNotFoundException
	 */
	public List<User> getUsersData() throws UserNotFoundException;

}

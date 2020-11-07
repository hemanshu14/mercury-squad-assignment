package com.assignment.usermanagement.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.usermanagement.constants.Constants;
import com.assignment.usermanagement.exceptions.UserNotFoundException;
import com.assignment.usermanagement.feign.clients.UserDataClient;
import com.assignment.usermanagement.model.User;
import com.assignment.usermanagement.services.UserService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Implementation of the interface to retrieve all the user details
 * 
 * @author hemanshu.banga
 *
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	
	private final UserDataClient userDataClient;

	/**
	 * 
	 * This is the implementation of the method to retrieve all the users details
	 *
	 * return the list of all the user details
	 * 
	 * @throws UserNotFoundException
	 */
	@Override
	public List<User> getUsersData() {

		List<User> users = userDataClient.getUsersData();

		if (users.isEmpty()) {
			throw new UserNotFoundException(Constants.ERROR_CODE, Constants.USERS_NOT_FOUND);
		}

		return users;
	}

	/**
	 * 
	 * This is the implementation of the method to retrieve the users details that
	 * matches with the given first name and last name
	 *
	 * return the list of user details that matches with the given first name and
	 * last name
	 * 
	 * @throws UserNotFoundException
	 */
	@Override
	public User getUserDataWithParams(String firstName, String lastName) {
		List<User> users = userDataClient.getUsersData();

		Optional<User> user = users.stream()
				.filter(userItem -> userItem.getName().getFirst().equalsIgnoreCase(firstName)
						&& userItem.getName().getLast().equalsIgnoreCase(lastName))
				.findAny();

		return user.orElseThrow(() -> new UserNotFoundException(Constants.ERROR_CODE, Constants.USER_NOT_FOUND));
	}

}

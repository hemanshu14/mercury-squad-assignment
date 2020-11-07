package com.assignment.usermanagement.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment.usermanagement.constants.Constants;
import com.assignment.usermanagement.exceptions.UserNotFoundException;
import com.assignment.usermanagement.model.User;
import com.assignment.usermanagement.services.UserService;

/**
 * 
 * Implementation of the interface to retrieve all the user details
 * 
 * @author hemanshu.banga
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${wiremock.stub.api}")
	private String wireMockStubbedApi;

	/**
	 * 
	 * This is the implementation of the method to retrieve all the users details
	 *
	 * return the list of all the user details
	 * 
	 * @throws UserNotFoundException
	 */
	@Override
	public List<User> getUsersData() throws UserNotFoundException {
		List<User> users = restTemplate
				.exchange(wireMockStubbedApi, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
				}).getBody();
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
	 * return the list of the user details that matches with the given first name
	 * and last name
	 * 
	 * @throws UserNotFoundException
	 */
	@Override
	public List<User> getUserDataWithParams(Optional<String> firstName, Optional<String> lastName)
			throws UserNotFoundException {
		List<User> users = restTemplate
				.exchange(wireMockStubbedApi, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
				}).getBody();

		List<User> usersArray = users.stream()
				.filter(user -> user.getName().getFirst().equalsIgnoreCase(firstName.get())
						&& user.getName().getLast().equalsIgnoreCase(lastName.get()))
				.collect(Collectors.toList());

		if (usersArray.isEmpty()) {
			throw new UserNotFoundException(Constants.ERROR_CODE, Constants.USER_NOT_FOUND);
		}
		return usersArray;
	}

}

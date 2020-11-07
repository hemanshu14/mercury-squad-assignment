package com.assignment.usermanagement.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

		ResponseEntity<List<User>> userListResponse = restTemplate.exchange(wireMockStubbedApi, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});

		List<User> userList = userListResponse.getBody();
		if (userList.isEmpty()) {
			throw new UserNotFoundException(Constants.ERROR_CODE, Constants.USERS_NOT_FOUND);
		}

		return userList;
	}

	/**
	 * 
	 * This is the implementation of the method to retrieve the users details that
	 * matches with the given first name and last name
	 *
	 * return the the user details that matches with the given first name and last
	 * name
	 * 
	 * @throws UserNotFoundException
	 */
	@Override
	public User getUserDataWithParams(String firstName, String lastName) throws UserNotFoundException {
		List<User> users = restTemplate
				.exchange(wireMockStubbedApi, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
				}).getBody();

		Optional<User> user = users.stream()
				.filter(userItem -> userItem.getName().getFirst().equalsIgnoreCase(firstName)
						&& userItem.getName().getLast().equalsIgnoreCase(lastName))
				.findAny();

		if (!user.isPresent()) {
			throw new UserNotFoundException(Constants.ERROR_CODE, Constants.USER_NOT_FOUND);
		}
		return user.get();
	}

}

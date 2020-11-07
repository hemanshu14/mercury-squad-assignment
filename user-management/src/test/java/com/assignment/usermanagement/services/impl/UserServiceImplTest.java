package com.assignment.usermanagement.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.assignment.usermanagement.exceptions.UserNotFoundException;
import com.assignment.usermanagement.model.Name;
import com.assignment.usermanagement.model.User;

@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	private List<User> userList;

	@BeforeEach
	public void setUp() {
		ReflectionTestUtils.setField(userServiceImpl, "wireMockStubbedApi", "wireMockStubbedApi");
		
		userList = new ArrayList<>();
		User user1 = new User();
		Name name1 = new Name();
		name1.setFirst("Karl");
		name1.setLast("winson");
		user1.setGender("male");
		user1.setName(name1);

		User user2 = new User();
		Name name2 = new Name();
		name2.setFirst("Karla");
		name2.setLast("gerrith");
		user2.setGender("female");
		user2.setName(name2);

		userList.add(user1);
		userList.add(user2);
	}

	@Test
	public void testGetUsersData_positiveFlow() throws UserNotFoundException {

		ResponseEntity<List<User>> userListEntity = new ResponseEntity<List<User>>(userList, HttpStatus.OK);

		when(restTemplate.exchange(ArgumentMatchers.anyString(), any(HttpMethod.class), any(),
				ArgumentMatchers.<ParameterizedTypeReference<List<User>>>any())).thenReturn(userListEntity);

		List<User> response	= userServiceImpl.getUsersData();
		assertEquals(userList, response);
	}
	
	@Test()
	public void testGetUsersData_UserNotFoundException() {
		ResponseEntity<List<User>> userListEntity = new ResponseEntity<List<User>>(new ArrayList<>(), HttpStatus.OK);

		when(restTemplate.exchange(ArgumentMatchers.anyString(), any(HttpMethod.class), any(),
				ArgumentMatchers.<ParameterizedTypeReference<List<User>>>any())).thenReturn(userListEntity);

		Throwable thrown = catchThrowable(() -> {
			userServiceImpl.getUsersData();
		});

		assertThat(thrown).isInstanceOf(UserNotFoundException.class);
	}
	
	@Test
	public void testGetUsersDataWithParams_positiveFlow() throws UserNotFoundException {
		
		ResponseEntity<List<User>> userListEntity = new ResponseEntity<List<User>>(userList, HttpStatus.OK);

		when(restTemplate.exchange(ArgumentMatchers.anyString(), any(HttpMethod.class), any(),
				ArgumentMatchers.<ParameterizedTypeReference<List<User>>>any())).thenReturn(userListEntity);

		User user	= userServiceImpl.getUserDataWithParams("Karl", "Winson");
		assertEquals(userList.get(0).getName().getFirst(), user.getName().getFirst());
		assertEquals(userList.get(0).getName().getLast(), user.getName().getLast());
	}
	
	@Test()
	public void testGetUsersDataWithParams_UserNotFoundException() {
		ResponseEntity<List<User>> userListEntity = new ResponseEntity<List<User>>(userList, HttpStatus.OK);

		when(restTemplate.exchange(ArgumentMatchers.anyString(), any(HttpMethod.class), any(),
				ArgumentMatchers.<ParameterizedTypeReference<List<User>>>any())).thenReturn(userListEntity);

		Throwable thrown = catchThrowable(() -> {
			userServiceImpl.getUserDataWithParams("Hemanshu", "Banga");
		});

		assertThat(thrown).isInstanceOf(UserNotFoundException.class);
	}
	
}

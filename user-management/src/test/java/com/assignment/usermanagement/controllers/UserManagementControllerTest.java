package com.assignment.usermanagement.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.assignment.usermanagement.exceptions.UserNotFoundException;
import com.assignment.usermanagement.model.Name;
import com.assignment.usermanagement.model.User;
import com.assignment.usermanagement.services.UserService;

@ExtendWith(SpringExtension.class)
public class UserManagementControllerTest {

	@InjectMocks
	private UserManagementController userManagementController;
	@Mock
	private UserService userService;

	@Test
	public void testGetUsers() throws UserNotFoundException {

		List<User> users = new ArrayList<>();
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

		users.add(user1);
		users.add(user2);

		when(userService.getUsersData()).thenReturn(users);

		assertEquals(2, userManagementController.getUsersData(null,null).getBody().size());
	}

	@Test
	public void testGetUsersWithParams() throws UserNotFoundException {
		
		List<User> users = new ArrayList<>();
		User user1 = new User();
		Name name1 = new Name();
		name1.setFirst("Karl");
		name1.setLast("winson");
		user1.setGender("male");
		user1.setName(name1);
		
		users.add(user1);
		
		User user = new User();
		Name name = new Name();
		name.setFirst("Karl");
		name.setLast("Winson");
		user.setGender("male");
		user.setName(name);
		when(userService.getUserDataWithParams("Karl", "Winson")).thenReturn(user);
		ResponseEntity<List<User>> userResponse = userManagementController.getUsersData("Karl", "Winson");
		assertEquals(name.getFirst(), userResponse.getBody().get(0).getName().getFirst());
		assertEquals(name.getLast(), userResponse.getBody().get(0).getName().getLast());

	}

}

package com.assignment.usermanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.usermanagement.controllers.UserManagementController;
import com.assignment.usermanagement.services.UserService;

@SpringBootTest
class UserManagementApplicationTests {
	
	@Autowired
	private UserManagementController userManagementController;
	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(userManagementController);
		Assertions.assertNotNull(userService);
	}

}

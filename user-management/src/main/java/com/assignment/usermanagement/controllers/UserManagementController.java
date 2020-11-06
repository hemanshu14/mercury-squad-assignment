package com.assignment.usermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.assignment.usermanagement.model.Users;

@RestController
@RequestMapping("/users")
public class UserManagementController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public ResponseEntity<Users> getUserData() {
		
		ResponseEntity<Users> usersEntity = restTemplate.getForEntity("http://localhost:8080/users/", Users.class);
		
		
		return new ResponseEntity<Users>(usersEntity.getBody(), HttpStatus.OK);
	}
}

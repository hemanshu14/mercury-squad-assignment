package com.assignment.usermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/mappings")
public class MappingsController {

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path="add")
	public ResponseEntity<Boolean> createMappings(@RequestBody String input){
		
		restTemplate.postForObject("http://localhost:8080/__admin/mappings", input, Object.class);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
}

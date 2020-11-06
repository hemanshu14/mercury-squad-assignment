package com.assignment.usermanagement.model;

import lombok.Data;

@Data
public class Location {

	private Street street;
	private String city;
	private String state;
	private String country;
	private Long postcode;
}

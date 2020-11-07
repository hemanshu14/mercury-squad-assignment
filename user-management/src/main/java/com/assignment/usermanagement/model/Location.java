package com.assignment.usermanagement.model;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * This is a POJO class for location details
 *
 * @author hemanshu.banga
 *
 */
@Data
public class Location implements Serializable {

	private static final long serialVersionUID = -8129293185592195852L;
	
	private Street street;
	private String city;
	private String state;
	private String country;
	private Long postcode;
}

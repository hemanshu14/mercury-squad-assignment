package com.assignment.usermanagement.model;

import java.io.Serializable;

import lombok.Data;

/**
*
* This is a POJO class for User details
*
* @author hemanshu.banga
*
*/
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -7219047284506492211L;
	
	private String gender;
	private Name name;
	private Location location;
	
}

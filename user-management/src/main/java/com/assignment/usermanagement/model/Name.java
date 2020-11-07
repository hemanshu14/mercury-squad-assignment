package com.assignment.usermanagement.model;

import java.io.Serializable;

import lombok.Data;

/**
*
* This is a POJO class for Name details
*
* @author hemanshu.banga
*
*/
@Data
public class Name implements Serializable {

	private static final long serialVersionUID = -3732062299608253757L;
	
	private String title;
	private String first;
	private String last;
	private String dob;
}

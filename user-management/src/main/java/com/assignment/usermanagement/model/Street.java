package com.assignment.usermanagement.model;

import java.io.Serializable;

import lombok.Data;

/**
*
* This is a POJO class for Street details
*
* @author hemanshu.banga
*
*/
@Data
public class Street implements Serializable {

	private static final long serialVersionUID = -623697801692634307L;
	
	private int number;
	private String name;
}

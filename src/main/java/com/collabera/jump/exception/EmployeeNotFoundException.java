package com.collabera.jump.exception;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public EmployeeNotFoundException(String message) {
		
		super(message);
	}

}

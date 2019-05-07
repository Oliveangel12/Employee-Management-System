package com.collabera.jump.exceptionadvice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.collabera.jump.exception.AddressNotFoundException;
import com.collabera.jump.exception.EmployeeNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> EmployeeNotFoundHandler(){
		
		return ResponseEntity.badRequest().body("Employee not found");
	}
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<?> AddressNotFoundHandler(){
		
		return ResponseEntity.badRequest().body("Address not found");
	}
}

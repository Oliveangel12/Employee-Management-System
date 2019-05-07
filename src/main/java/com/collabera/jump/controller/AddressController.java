package com.collabera.jump.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.jump.Employee;
import com.collabera.jump.model.Address;

import com.collabera.jump.service.EmployeeService;

@RestController
@RequestMapping(path= "address")
public class AddressController {

	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping(path= {"/street"}, produces= { MediaType.APPLICATION_JSON_VALUE},
			consumes= { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> getEmployeeByStreet(@RequestParam(name="street", required=true)String street){

		return ResponseEntity.ok().body(service.getByStreet(street));
		
}
	
	@PutMapping(produces= { MediaType.APPLICATION_JSON_VALUE},
			consumes= { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> updateEmployeeByStreet(@RequestBody Employee employee){

		return ResponseEntity.ok().body(service.updateEmployeeByStreet(employee));
		
}
	@DeleteMapping(produces= { MediaType.APPLICATION_JSON_VALUE},
			consumes= { MediaType.APPLICATION_JSON_VALUE})
	public boolean deleteEmployeeByStreet(@RequestParam(name="street", required=true)String street){

		return service.deleteEmployeeByStreet(street);
}
}



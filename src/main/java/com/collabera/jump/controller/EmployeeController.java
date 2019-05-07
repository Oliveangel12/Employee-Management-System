package com.collabera.jump.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.collabera.jump.Employee;
import com.collabera.jump.exception.EmployeeNotFoundException;
import com.collabera.jump.service.EmployeeService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController 
@RequestMapping(path = "/employee")
public class EmployeeController {//controller is specific to protocol/channel(HTTP) that service class is java
//Controller have status code, representation, responses info
	@Autowired
	private EmployeeService service;
//	
	
	@CrossOrigin(origins="*")
	@ApiResponses({@ApiResponse(code=400,message="Employee not found", response=EmployeeNotFoundException.class)})
	@GetMapping(path= "/getallemployee", produces= {MediaType.APPLICATION_JSON_VALUE})
	public Iterable<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	@CrossOrigin(origins="*")
	@ApiResponses({@ApiResponse(code=400,message="Employee not found", response=EmployeeNotFoundException.class)})
	@GetMapping(path= "/empl/{empId}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public Employee getEmployee(@ApiParam (name="empId", required=true, allowEmptyValue=false)@PathVariable(name = "empId", required = true) int empId){
		return service.getEmployee(empId);
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(path= "/emp/{email}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public Employee findByEmail(@ApiParam (name="email", required=true, allowEmptyValue=false)@PathVariable(name = "email", required = true) String email){
		return service.findByEmail(email);
	}
	@CrossOrigin(origins="*")
	@GetMapping(path= "/address/{street}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public Employee getEmployeeByStreet(@ApiParam (name="street", required=true, allowEmptyValue=false)@PathVariable(name = "street", required = true) String street){
		return service.findByStreet(street);
	}
	@GetMapping(path= "/phone/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public String getEmployeeByContact(@ApiParam (name="id", required=true, allowEmptyValue=false)@PathVariable(name = "id", required = true) int empId){
		return service.findPhoneNumberByEmpId(empId);
	}
	
	@GetMapping(path="/{ssn}",produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<?> getBySsn(String ssn){
		
		return ResponseEntity.ok(service.findBySsn(ssn));
	}
	@CrossOrigin(origins="*")
	@PostMapping(produces= { MediaType.APPLICATION_JSON_VALUE},
			consumes= { MediaType.APPLICATION_JSON_VALUE})
	public Employee createEmployee( @Valid @RequestBody Employee employee) {

		return service.createREmployee(employee);

	}
	@CrossOrigin(origins="*")
	@PutMapping(path= "{id}", produces= { MediaType.APPLICATION_JSON_VALUE},
			consumes= { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable(name = "id", required = true) int empId) {
	
		
			return	ResponseEntity.ok(service.updateREmployee(employee, empId));
		}
		
	@CrossOrigin(origins="*")
	@DeleteMapping(path="/empd/{id}", produces= { MediaType.APPLICATION_JSON_VALUE},
			consumes= { MediaType.APPLICATION_JSON_VALUE})
	public boolean deleteEmployee(@PathVariable(name = "id", required = true) int empId) {

		return service.deleteREmployee(empId);
	}
}




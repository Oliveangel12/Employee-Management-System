package com.collabera.jump.service;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.collabera.jump.Employee;
import com.collabera.jump.Employee.DEPARTMENT;
import com.collabera.jump.Employee.TITLE;
import com.collabera.jump.exception.AddressNotFoundException;
import com.collabera.jump.exception.EmployeeNotFoundException;
import com.collabera.jump.model.Address;
import com.collabera.jump.model.Person.GENDER;
import com.collabera.jump.repositories.EmployeeRepository;

@Service //not aware who is invoking, all the business code is here
public class EmployeeService {
	
	static private HashMap<Integer, Employee> employees;
	static private HashMap<String, Employee> employeeadd;

	static {

		employees = new HashMap<>();
		employeeadd=new HashMap<>();
		Employee emp = new Employee(1, "Olive", 23, GENDER.FEMALE, "12-12-1995", DEPARTMENT.IT, "987456321",
				" olive@gmail.com", 987456, 1, TITLE.DEVELOPER, "9874563210");

		Address addr = new Address();

		addr.setStreet("Guilford road");
		addr.setCity("Jessup");
		addr.setZipcode("20794");
		addr.setState("Maryland");

		emp.setAddress(addr);
		employees.put(1, emp);
		employeeadd.put(addr.getStreet(),emp);

	}

	// if we declare methods as static, it complains when we try to access it bcz static is class level
	public  Employee getByID(int empId) {
		Employee e = employees.get(empId);
		System.out.println(e);
		return e;
	}
	
	public  HashMap<Integer, Employee> getEmployees() {
		return employees;
		
	}
	@Autowired
	private EmployeeRepository empRepository;
	
	
	
	public  Employee getEmployee(Integer empId) {
		
		return empRepository.findByEmpId(empId);
		
	}
	public Iterable<Employee> getAllEmployees(){
        return empRepository.findAll();
    }
      
	public Employee createREmployee(Employee employee) {
        return empRepository.saveAndFlush(employee);
    }
    public Employee updateREmployee(Employee employee, Integer empId) {
    	
    	if(empRepository.existsById(empId) && employee.getEmpId()==empId)
    	return empRepository.saveAndFlush(employee);
    	else
    		throw new EmployeeNotFoundException("Employee with empId" + empId + "is not found and cannot be updated");
    }
        
    public boolean deleteREmployee(Integer empId) {
        if(empRepository.existsById(empId)) {
            empRepository.deleteById(empId);
            return true;
        }else {
            return false;
        }
    }
    public Employee findByEmail(String email) {
        return empRepository.findByEmail(email);
    }
    public Employee findByStreet(String street) {
        return empRepository.findByStreet(street);
    }
    
    public String findPhoneNumberByEmpId(Integer empID) {
    	
    	return empRepository.findPhoneNumberbyEmpId(empID);
}
    
    public ResponseEntity<List<Employee>> findBySsn(String ssn) {
    	return ResponseEntity.ok(empRepository.findBySsn(ssn));
}
	
	public  Employee getByStreet(String street) {
		
		
		Employee e = employeeadd.get(street);
		
		if(e!=null) {
			
			return e;
		}
		else {
			
			throw new AddressNotFoundException("Employee with street" +street + "is not found");
		}
	}

	// create an employee
	public  Employee createEmployee(Employee emp) {

		
		
		if (emp != null) {

			employees.put(emp.getEmpId(), emp);

			return emp;
		}
		return emp;

	}

	
//	public  Employee createEmployeeByStreet(Employee emp) {
//		
//		if (emp != null) {
//
//			employeeadd.put("addr.getStreet()",emp);
//			
//			System.out.println(emp);
//
//			return emp;
//		}
//		return emp;
//		
//
//	}

	public  Employee updateEmployee(Employee emp) {

		employees.put(emp.getEmpId(), emp);

		return emp;
	}
	
	public  Employee updateEmployeeByStreet(Employee emp){

		if(emp!=null) {
			
		employeeadd.put("addr.getStreet()", emp);

		return emp;
		}
	return emp;
	}

	
		public boolean deleteEmployee(int id) {
		 Employee emp = employees.remove(id);
		employees.remove(id);
	//	 if you want to know if we deleted the emp who exists and who doesn't exist
		if(emp!=null)
		{
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean deleteEmployeeByStreet(String street) {
		
		employeeadd.remove(street);
		
		return true;
		
	}
	
	}	

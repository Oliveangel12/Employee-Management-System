package com.collabera.jump.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.collabera.jump.Employee;

@Repository//connecting to DB, caching in hibernate
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee findByEmail(String email);
	
	@Query("SELECT e FROM Employee e where e.address.street=: street")
	Employee findByStreet(String street);
	
	@Query(value="SELECT contactNumber from EMPLOYEE where empId= ?1", nativeQuery=true)//query to get values from emp obj
	String findPhoneNumberbyEmpId(Integer empId);
	
	
	List<Employee> findBySsn(String ssn);
	
	Employee findByEmpId(int empId);
	
	Employee findBySsnAndEmpId(String ssn, Integer empId);// query by example
}

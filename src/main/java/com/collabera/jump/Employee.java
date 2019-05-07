package com.collabera.jump;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.collabera.jump.model.Address;
import com.collabera.jump.model.Person;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Employee extends Person implements Serializable{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum DEPARTMENT{
		HR,SALES,IT;
	}
	
	public enum TITLE{
	
		DEVELOPER, CONSULTANT,ACCOUNTANT;
	}
		@Id
		@GeneratedValue
		private int empId;
		public int getEmpId() {
			return empId;
		}


		public void setEmpId(int empId) {
			this.empId = empId;
		}
		
		@NotNull
		@ApiModelProperty(notes="Please make sure you enter 9 digits")
		private String ssn;
		private String email;
		private double salary;
		private int reportsTo;
		
		@Enumerated(EnumType.STRING)
		private DEPARTMENT department;
		
		@Enumerated(EnumType.STRING)
		private TITLE jobTitle;
		
		@Valid
		@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true) //CascadeType.Remove if employee is removed address is also removed
		private Address address;
	
		
		public Address getAddress() {
			return address;
		}


		public void setAddress(Address address) {
			this.address = address;
		}

		
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Employee(int empId, String name, int age, GENDER gender, String DOB, DEPARTMENT department, String ssn, String email,
				double salary, int reportsTo, TITLE jobTitle, String contactNumber) {
			
			super(name, age, contactNumber, DOB, gender); //getting values from Person class
			
			this.empId= empId;
			this.department = department;
			this.ssn = ssn;
			this.email = email;
			this.salary = salary;
			this.reportsTo = reportsTo;
			this.jobTitle = jobTitle;
			
		}
		
		
		public DEPARTMENT getDepartment() {
			return department;
		}
		public void setDepartment(DEPARTMENT department) {
			this.department = department;
		}
		public String getSsn() {
			return ssn;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public int getReportsTo() {
			return reportsTo;
		}
		public void setReportsTo(int reportsTo) {
			this.reportsTo = reportsTo;
		}
		public TITLE getJobTitle() {
			return jobTitle;
		}
		public void setJobTitle(TITLE jobTitle) {
			this.jobTitle = jobTitle;
		}
		
}
		
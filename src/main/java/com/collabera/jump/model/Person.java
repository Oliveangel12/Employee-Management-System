package com.collabera.jump.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

//@Entity (Bcz employee is primary)
@MappedSuperclass
public class Person implements Serializable{

	
		public enum GENDER {
			MALE, FEMALE,OTHER;
		}

		@Size(min=5, max =15, message="The name should contain characters between 5-15")
		private String name;
//Constructor 
		public Person(String name, int age, String contactNumber, String dOB, GENDER gender) {
			
			this.name = name;
			this.age = age;
			this.contactNumber = contactNumber;
			this.DOB = dOB;
			this.gender = gender;
		}

		

		public Person() {
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		public String getDOB() {
			return DOB;
		}

		public void setDOB(String dOB) {
			DOB = dOB;
		}

		public GENDER getGender() {
			return gender;
		}

		public void setGender(GENDER gender) {
			this.gender = gender;
		}

		@NotNull
		@NonNull
		private int age;

		private String contactNumber;

		private String DOB;

		@Enumerated(EnumType.STRING)
		private GENDER gender;

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", contactNumber=" + contactNumber + ", DOB=" + DOB
					+ ", gender=" + gender + "]";
		}
		
		

}

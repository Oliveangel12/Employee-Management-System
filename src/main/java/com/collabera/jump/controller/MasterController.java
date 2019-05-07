package com.collabera.jump.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.jump.Employee.DEPARTMENT;
import com.collabera.jump.Employee.TITLE;
import com.collabera.jump.model.Person.GENDER;

@RestController
@RequestMapping("/master")
public class MasterController {

	
	@GetMapping("departments")
	public ResponseEntity<DEPARTMENT[]> getDepartments(){
		
		return ResponseEntity.ok(DEPARTMENT.values());
	}
	
	@GetMapping("jobtitles")
	public ResponseEntity<TITLE[]> getJobTitles(){
		
		return ResponseEntity.ok(TITLE.values());
	}
	
	@GetMapping("gender")
	public ResponseEntity<GENDER[]> getGender(){
		
		return ResponseEntity.ok(GENDER.values());
	}
	
	@GetMapping("all")
	public ResponseEntity<?> getAll(){
		
		HashMap<String, Object> allMasterData = new HashMap<String, Object>();
		
		allMasterData.put("departments", DEPARTMENT.values());
		allMasterData.put("jobtitles", TITLE.values());
		allMasterData.put("gender", GENDER.values());
		
		return ResponseEntity.ok(allMasterData);
		
	}
	
}

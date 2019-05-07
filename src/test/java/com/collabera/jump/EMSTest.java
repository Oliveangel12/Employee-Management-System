package com.collabera.jump;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EMSTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void acreateEmployee() throws Exception{
		
		mockMvc.perform(post("/employee")).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				   .andExpect(jsonPath("$ employee").value("{\r\n" + 
				"    \"name\": \"Angel\",\r\n" + 
				"    \"age\": 21,\r\n" + 
				"    \"contactNumber\": \"9874563210\",\r\n" + 
				"    \"gender\": \"FEMALE\",\r\n" + 
				"    \"empId\": 1,\r\n" + 
				"    \"ssn\": \"987456321\",\r\n" + 
				"    \"email\": \" olive@gmail.com\",\r\n" + 
				"    \"salary\": 987456,\r\n" + 
				"    \"reportsTo\": 1,\r\n" + 
				"    \"department\": \"IT\",\r\n" + 
				"    \"jobTitle\": \"DEVELOPER\",\r\n" + 
				"    \"address\": {\r\n" + 
				"        \"street\": \"Guilford\",\r\n" + 
				"        \"city\": \"Jessup\",\r\n" + 
				"        \"zipcode\": \"20794\",\r\n" + 
				"        \"state\": \"Maryland\"\r\n" + 
				"    },\r\n" + 
				"    \"dob\": \"12-12-1995\"\r\n" + 
				"}"));
	}
//	@Test
//	public void bgetEmployee() throws Exception {
//	
//	mockMvc.perform(get("/employee")).andExpect(status().isOk()).andExpect(content().json("{\r\n" + 
//			"    \"name\": \"Angel\",\r\n" + 
//			"    \"age\": 21,\r\n" + 
//			"    \"contactNumber\": \"9874563210\",\r\n" + 
//			"    \"gender\": \"FEMALE\",\r\n" + 
//			"    \"empId\": 1,\r\n" + 
//			"    \"ssn\": \"987456321\",\r\n" + 
//			"    \"email\": \" olive@gmail.com\",\r\n" + 
//			"    \"salary\": 987456,\r\n" + 
//			"    \"reportsTo\": 1,\r\n" + 
//			"    \"department\": \"IT\",\r\n" + 
//			"    \"jobTitle\": \"DEVELOPER\",\r\n" + 
//			"    \"address\": {\r\n" + 
//			"        \"street\": \"Guilford\",\r\n" + 
//			"        \"city\": \"Jessup\",\r\n" + 
//			"        \"zipcode\": \"20794\",\r\n" + 
//			"        \"state\": \"Maryland\"\r\n" + 
//			"    },\r\n" + 
//			"    \"dob\": \"12-12-1995\"\r\n" + 
//			"}"));
//
//}
//	
//	
//	@Test
//	public void cupdateEmployee() throws Exception{
//		
//		mockMvc.perform(put("/employee")).andExpect(status().isOk()).andExpect(content().json("{\r\n" + 
//				"    \"name\": \"Angel\",\r\n" + 
//				"    \"age\": 21,\r\n" + 
//				"    \"contactNumber\": \"9874563210\",\r\n" + 
//				"    \"gender\": \"FEMALE\",\r\n" + 
//				"    \"empId\": 1,\r\n" + 
//				"    \"ssn\": \"987456321\",\r\n" + 
//				"    \"email\": \" olive@gmail.com\",\r\n" + 
//				"    \"salary\": 987456,\r\n" + 
//				"    \"reportsTo\": 1,\r\n" + 
//				"    \"department\": \"IT\",\r\n" + 
//				"    \"jobTitle\": \"DEVELOPER\",\r\n" + 
//				"    \"address\": {\r\n" + 
//				"        \"street\": \"Guilford\",\r\n" + 
//				"        \"city\": \"Jessup\",\r\n" + 
//				"        \"zipcode\": \"20794\",\r\n" + 
//				"        \"state\": \"Maryland\"\r\n" + 
//				"    },\r\n" + 
//				"    \"dob\": \"12-12-1995\"\r\n" + 
//				"}"));
//	}
//	
//	@Test
//	public void ddeleteEmployee() throws Exception{
//		
//		mockMvc.perform(delete("/employee")).andExpect(status().isOk()).andExpect(content().json("{\r\n" + 
//				"    \"name\": \"Angel\",\r\n" + 
//				"    \"age\": 21,\r\n" + 
//				"    \"contactNumber\": \"9874563210\",\r\n" + 
//				"    \"gender\": \"FEMALE\",\r\n" + 
//				"    \"empId\": 1,\r\n" + 
//				"    \"ssn\": \"987456321\",\r\n" + 
//				"    \"email\": \" olive@gmail.com\",\r\n" + 
//				"    \"salary\": 987456,\r\n" + 
//				"    \"reportsTo\": 1,\r\n" + 
//				"    \"department\": \"IT\",\r\n" + 
//				"    \"jobTitle\": \"DEVELOPER\",\r\n" + 
//				"    \"address\": {\r\n" + 
//				"        \"street\": \"Guilford\",\r\n" + 
//				"        \"city\": \"Jessup\",\r\n" + 
//				"        \"zipcode\": \"20794\",\r\n" + 
//				"        \"state\": \"Maryland\"\r\n" + 
//				"    },\r\n" + 
//				"    \"dob\": \"12-12-1995\"\r\n" + 
//				"}"));
//	}
//}
}
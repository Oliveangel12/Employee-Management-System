//package com.collabera.jump.controller;
//
//import static org.junit.Assert.*;
//
//import java.time.Duration;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
//@AutoConfigureDataJpa
//@AutoConfigureMockMvc
//public class EmployeeControllerTest {
//
//	@TestConfiguration
//    static class Config {
//
//        @Bean
//        public RestTemplateBuilder restTemplateBuilder() {
//            return new RestTemplateBuilder().setConnectTimeout(Duration.ofSeconds(1))
//                    .setReadTimeout(Duration.ofSeconds(1));
////        }
//	TestRestTemplate restTemplate= new TestRestTemplate(new RestTemplateBuilder());
//	@Test
//	public void getEmployee() {
//		System.out.println("Http port:" + port);
//	}
//
//	
//	
//
//    }
//}

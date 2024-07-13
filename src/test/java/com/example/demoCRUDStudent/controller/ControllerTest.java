package com.example.demoCRUDStudent.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demoCRUDStudent.dto.StudentDto;
import com.example.demoCRUDStudent.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = StudentController.class)
@AutoConfigureMockMvc(addFilters = false)//related to security
@ExtendWith(MockitoExtension.class)
public class ControllerTest {
	
	//to test controllers MockMvc is used
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StudentService service;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	StudentDto dto;
	
	@BeforeEach  //runs before each testcase .. used to init dtos such things
	public void init() {
		dto=new StudentDto();
		dto.setName("vk");
		dto.setEmailAddr("vk@kv.com");
	}
	
	
	@Test
	public void studentController_Create_thenREturnResponseEntity() throws JsonProcessingException, Exception {
		//mock the service 
		 //configures the service mock object such that when the saveStudent method is called with any argument, it will return the first argument passed to it. 
		
		//given(service.saveStudent(ArgumentMatchers.any())).willAnswer(invoction->invocation.getArgument(0));
		
	
		MvcResult res=mockMvc.perform(MockMvcRequestBuilders.post("/student")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(dto)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andReturn();
		
		
		//System.out.println(mapper.writeValueAsString(res));
	}
	
	
	
	
	
	

}

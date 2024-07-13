package com.example.demoCRUDStudent.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoCRUDStudent.dto.StudentDto;
import com.example.demoCRUDStudent.service.StudentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
	
	private final StudentService service;

	@GetMapping("/byid/{id}")
	public ResponseEntity<StudentDto>getById(@PathVariable("id") String id){
		StudentDto dto=service.getById(id);
		return new ResponseEntity<StudentDto>(dto,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> saveStudent(@RequestBody StudentDto dto){
		service.saveStudent(dto);
		return new ResponseEntity<String>("saved successfully",HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<StudentDto>>getAll(){
		List<StudentDto> dto=service.getAll();
		return new ResponseEntity<List<StudentDto>>(dto,HttpStatus.OK);
	}
	
	
}

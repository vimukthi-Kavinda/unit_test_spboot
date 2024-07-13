package com.example.demoCRUDStudent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demoCRUDStudent.dto.StudentDto;
import com.example.demoCRUDStudent.entity.Student;
import com.example.demoCRUDStudent.repo.StudentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	
	private final StudentRepo repo;

	public StudentDto getById(String id) {
		Student s=repo.findById(Integer.valueOf(id)).orElse(null);
		return StudentDto.from(s);
	}

	public void saveStudent(StudentDto dto) {
		Student student=new Student();
		student.setEmailAddr(dto.getEmailAddr());
		student.setName(dto.getName());
		repo.saveAndFlush(student);
		
	}

	public List<StudentDto> getAll() {
		return repo.findAll().stream().map(StudentDto::from).toList();
	}

}

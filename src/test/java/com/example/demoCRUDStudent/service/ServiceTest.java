package com.example.demoCRUDStudent.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demoCRUDStudent.dto.StudentDto;
import com.example.demoCRUDStudent.entity.Student;
import com.example.demoCRUDStudent.repo.StudentRepo;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	
	//mock the dependancy
	@Mock
	private StudentRepo repo;
	
	//inject dependencies to service
	@InjectMocks
	private StudentService service;
	
	
	@Test
	public void StudentService_save_shouldReturnNone() {
		//arrange
		//create a student to save
		StudentDto student=new StudentDto();
		student.setName("kavinda");
		student.setEmailAddr("Panadura");
		
		Student se=new Student();
		se.setName("kavinda");
		se.setEmailAddr("Panadura");
		
		//mock repository
		//any Student obj saves with repo.saveAndFlush() then it return a entity obj
		when(repo.saveAndFlush(Mockito.any(Student.class)))
		.thenReturn(se);
		
		
		//act
		service.saveStudent(student);
	
		
		//assert
		//chk weather repo method called one time with any Student object
		verify(repo, times(1)).saveAndFlush(Mockito.any(Student.class));
		
	}
	
	@Test
	public void StudentService_getById_shouldReturnEntity() {
		//arrange
		//string id iscreated
		String id="1";
		
		Student se=new Student();
		se.setId(1);
		se.setName("kavinda");
		se.setEmailAddr("Panadura");
		
		//mock repository
		when(repo.findById(Mockito.any(Integer.class)))
		.thenReturn(Optional.of(se));
		
		
		//act
		StudentDto res=service.getById(id);
	
		
		//assert
		//chk weather repo method called one time with any number
		verify(repo, times(1)).findById(Mockito.any(Integer.class));
		
		assertNotNull(res);
		assertEquals("kavinda", res.getName());
		assertEquals("Panadura", res.getEmailAddr());
		
	}
	
	//for update mock both repo action.. findbyid and saveandflush
	
	
}

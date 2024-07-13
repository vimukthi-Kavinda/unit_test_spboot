package com.example.demoCRUDStudent.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demoCRUDStudent.entity.Student;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RepoTest {

	//arrange
	@Autowired
	StudentRepo repo;
	
	@Test
	public void StudentRepo_saveNflush_shouldReturnEntiy() {
		//arrange
		//create a student to save
		Student student=new Student();
		student.setName("kavinda");
		student.setEmailAddr("Panadura");
		
		//act
		Student s=repo.saveAndFlush(student);
	
		//assert
		assertNotNull(s);
		assertEquals(student.getName(), s.getName());
		assertEquals(student.getEmailAddr(), s.getEmailAddr());
		assertNotNull(s.getId());
	}
	
	
	@Test
	public void StudentRepo_getAll_shouldReturnEntiyList() {
		//arrange
		//create a student to save
		Student student=new Student();
		student.setName("bbb");
		student.setEmailAddr("Panadura");
		repo.saveAndFlush(student);
		
		Student student1=new Student();
		student1.setName("aaa");
		student1.setEmailAddr("Panadura");
		repo.saveAndFlush(student1);
		
		Student student2=new Student();
		student2.setName("aaa");
		student2.setEmailAddr("kalutara");
		repo.saveAndFlush(student2);
		
		//act
		List<Student> s=repo.findAll();
	
		//assert
		assertNotNull(s);
		assertNotNull(s.get(0));
		assertNotNull(s.get(0).getId());
		assertThat(s.size()).isGreaterThan(0);
	}
	
	
	@Test
	public void StudentRepo_getByName_shouldReturnEntiyList() {
		//arrange
		//create a student to save
		Student student=new Student();
		student.setName("bbb");
		student.setEmailAddr("Panadura");
		repo.saveAndFlush(student);
		
		Student student1=new Student();
		student1.setName("aaa");
		student1.setEmailAddr("Panadura");
		repo.saveAndFlush(student1);
		
		Student student2=new Student();
		student2.setName("aaa");
		student2.setEmailAddr("kalutara");
		repo.saveAndFlush(student2);
		
		//act
		List<Student> s=repo.findByName("aaa");
	
		//assert
		assertNotNull(s);
		assertNotNull(s.get(0));
		assertNotNull(s.get(0).getId());
		assertNotNull(s.get(0).getName());
		assertEquals("aaa",s.get(0).getName());
		assertThat(s.size()).isGreaterThan(0);
	}
	
	//write for update and delete
	
}

package com.example.demoCRUDStudent.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demoCRUDStudent.entity.Student;
public interface StudentRepo extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student>{

	List<Student> findByName(String s);

}

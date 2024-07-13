package com.example.demoCRUDStudent.dto;

import com.example.demoCRUDStudent.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

	private Integer id;
	private String name;
	private String emailAddr;
	
	
	public static StudentDto from(Student s) {
		return StudentDto.builder()
				.id(s.getId())
				.name(s.getName())
				.emailAddr(s.getEmailAddr())
				.build();
	}
	
	
}

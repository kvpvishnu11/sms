package com.myproj.spring.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.entities.Student;
import com.myproj.spring.sms.repositories.StudentRepository;

@Component
public class StudentImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveTheNewStudent(Student s) {
		 
		return studentRepository.save(s);
	}

}

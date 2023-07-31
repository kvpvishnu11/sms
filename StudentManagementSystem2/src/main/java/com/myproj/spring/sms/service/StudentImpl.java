package com.myproj.spring.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.entities.Student;
import com.myproj.spring.sms.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Component
public class StudentImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	@Override
	public Student saveTheNewStudent(Student s) {
		 
		return studentRepository.save(s);
	}

	@Override
	public Student findStudentUsingID(Long id) {
		 
		return studentRepository.findByStudentid(id);
	}

}

package com.myproj.spring.sms.service;

/** Implementation class for Student Service Interface that implements CRUD operations **/
/** Saves new students, gets the students by their Id's **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.entities.Student;
import com.myproj.spring.sms.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Component
public class StudentImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	/** Save the new Student record **/
	@Transactional
	@Override
	public Student saveTheNewStudent(Student s) {
		 
		return studentRepository.save(s);
	}
	
	/** Find the student using the student id**/

	@Override
	public Student findStudentUsingID(Long id) {
		 
		return studentRepository.findByStudentid(id);
	}

}

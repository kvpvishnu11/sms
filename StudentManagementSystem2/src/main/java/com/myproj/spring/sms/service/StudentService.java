package com.myproj.spring.sms.service;

/** Service Interface that contains methods for Saving new students and fetching them by their Id's **/

import com.myproj.spring.sms.entities.Student;

public interface StudentService {
	
	public Student saveTheNewStudent(Student s);
	
	public Student findStudentUsingID(Long id);

}

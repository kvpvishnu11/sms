package com.myproj.spring.sms.service;

/** Service interface that contains methods to fetch all teachers, fetch students enrolled in their class, fetch teacher using their id's **/

import java.util.List;

import com.myproj.spring.sms.dto.StudentListDTO;
import com.myproj.spring.sms.dto.StudentListDTOImpl;
import com.myproj.spring.sms.dto.TeacherListDTOImpl;
import com.myproj.spring.sms.entities.Student;
import com.myproj.spring.sms.entities.Teacher;

public interface TeacherService {
	
	public Teacher saveTheNewTeacher(Teacher t);
	
	public List<StudentListDTOImpl> getStudents(long teacherid);
	
	public List<TeacherListDTOImpl> listAllTeachers();
	
	public Teacher findTeacherUsingID(Long id);


}

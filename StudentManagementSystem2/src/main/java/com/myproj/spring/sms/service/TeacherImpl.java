package com.myproj.spring.sms.service;

/** Implementation class that Performs CRUD operations on Teacher Service interface **/
/** Used to get Students enrolled in a teacher's course, get list of all teachers and fetch a teacher using theid ID's **/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.dto.StudentListDTO;
import com.myproj.spring.sms.dto.StudentListDTOImpl;
import com.myproj.spring.sms.dto.TeacherListDTOImpl;
import com.myproj.spring.sms.entities.Teacher;
import com.myproj.spring.sms.repositories.TeacherRepository;

import jakarta.transaction.Transactional;

@Component
public class TeacherImpl implements TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	/** Saving a new teacher into the db **/
	@Transactional
	@Override
	public Teacher saveTheNewTeacher(Teacher t) {
		 
		return teacherRepository.save(t);
	}
	
	/** Getting the list of students under a particular teacher using teacher id **/
	@Override
	public List<StudentListDTOImpl> getStudents(long teacherid) {
		 
		return teacherRepository.fetchStudentsByTeacherId(teacherid);
	}
	
	/** List down all the teachers**/

	@Override
	public List<TeacherListDTOImpl> listAllTeachers() {
		 
		return teacherRepository.listAllTeachers();
	}
	
	/** Find out the teacher details using teacher id **/

	@Override
	public Teacher findTeacherUsingID(Long id) {
		 
		return teacherRepository.findByTeacherid(id);
	}

}

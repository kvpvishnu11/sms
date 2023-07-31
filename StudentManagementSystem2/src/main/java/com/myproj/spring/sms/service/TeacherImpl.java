package com.myproj.spring.sms.service;

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
	
	@Transactional
	@Override
	public Teacher saveTheNewTeacher(Teacher t) {
		 
		return teacherRepository.save(t);
	}

	@Override
	public List<StudentListDTOImpl> getStudents(long teacherid) {
		 
		return teacherRepository.fetchStudentsByTeacherId(teacherid);
	}

	@Override
	public List<TeacherListDTOImpl> listAllTeachers() {
		 
		return teacherRepository.listAllTeachers();
	}

	@Override
	public Teacher findTeacherUsingID(Long id) {
		// TODO Auto-generated method stub
		return teacherRepository.findByTeacherid(id);
	}

}

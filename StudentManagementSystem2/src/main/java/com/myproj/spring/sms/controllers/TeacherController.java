package com.myproj.spring.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.dto.StudentListDTO;
import com.myproj.spring.sms.dto.StudentListDTOImpl;
import com.myproj.spring.sms.dto.TeacherListDTOImpl;
import com.myproj.spring.sms.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/fetchstudents/{teacherid}")
	public List<StudentListDTOImpl> displayListOfStudentsFromTeacherID(@PathVariable("teacherid") Long teacherid){
		
		return teacherService.getStudents(teacherid);
	}
	
	@GetMapping("/getall")
	public List<TeacherListDTOImpl> displayListOfStudentsFromTeacherID(){
		
		return teacherService.listAllTeachers();
	}

}

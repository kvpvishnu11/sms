package com.myproj.spring.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.dto.StudentListDTO;
import com.myproj.spring.sms.dto.StudentListDTOImpl;
import com.myproj.spring.sms.dto.TeacherListDTOImpl;
import com.myproj.spring.sms.service.TeacherService;

/**
 * This controller handles the requests to fetch students enrolled in that
 * teacher's course and get all teachers
 **/

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	/** Fetching list of students from a teacher id **/
	@GetMapping("/fetchstudents/{teacherid}")
	public ResponseEntity<?> displayListOfStudentsFromTeacherID(@PathVariable("teacherid") Long teacherid) {
		// Check if the teacher id is null or invalid
		if (teacherid == null || teacherid <= 0) {
			return ResponseEntity.badRequest().body("Invalid Teacher ID.");
		}
		List<StudentListDTOImpl> students = teacherService.getStudents(teacherid);
		if (students == null || students.isEmpty()) {
			return ResponseEntity.badRequest().body("No students found for the given teacher ID.");
		}
		return ResponseEntity.ok(students);
	}

	/** List all teachers present in the DB on Admin Portal **/
	@GetMapping("/getall")
	public List<TeacherListDTOImpl> displayAllTeachers() {

		return teacherService.listAllTeachers();
	}

}

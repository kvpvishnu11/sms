package com.myproj.spring.sms.controllers;

 import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.dto.BrowseCoursesDTO;
import com.myproj.spring.sms.dto.EnrollmentDTO;
import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.entities.Enrollment;
import com.myproj.spring.sms.service.EnrollmentService;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
	
	@Autowired
	private EnrollmentService enrollmentService;
	
	@PostMapping("/save")
	public EnrollmentDTO saveAllEnrollments(@RequestBody EnrollmentDTO e) {
		return enrollmentService.saveEnrollments(e);
		
	}
	
	// Browsing the courses using the student id
	 
	@GetMapping("/browse/{student_id}")
	public List<BrowseCoursesDTO> browseEnrollments(@PathVariable("student_id") long student_id) {
	    List<Enrollment> originalEnrollments = enrollmentService.listAllCoursesByStudentID(student_id);

	    List<BrowseCoursesDTO> filteredCourses = new ArrayList<>();

	    for (Enrollment enrollment : originalEnrollments) {
	        BrowseCoursesDTO filteredCourse = new BrowseCoursesDTO();
	        filteredCourse.setCourseid(enrollment.getCourseid());
	        filteredCourse.setCoursename(enrollment.getCoursename());
	        filteredCourses.add(filteredCourse);
	    }

	    return filteredCourses;
	}


		
	}



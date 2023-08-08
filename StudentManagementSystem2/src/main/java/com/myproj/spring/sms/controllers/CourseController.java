package com.myproj.spring.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/getall")
	public List<Course> getAllCourses(){
		
	 return	courseService.listAllCourses();
		
	}
	
	@PostMapping("/saveall")
	public ResponseEntity<?> saveCourses(@RequestBody List<Course> c) {
	    if (c == null || c.isEmpty()) {
	        return ResponseEntity.badRequest().body("Request body is empty.");
	    } else {
	        List<Course> savedCourses = courseService.postAllCourses(c);
	        return ResponseEntity.ok(savedCourses);
	    }
	}


}

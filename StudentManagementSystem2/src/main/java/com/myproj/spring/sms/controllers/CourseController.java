package com.myproj.spring.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Course> saveCourses(@RequestBody List<Course> c){
		
		return courseService.postAllCourses(c);
		
		
	}

}

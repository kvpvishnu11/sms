package com.myproj.spring.sms.service;

import java.util.List;

import com.myproj.spring.sms.entities.Course;

public interface CourseService {
	
	public List<Course> listAllCourses();
	
	public List<Course> postAllCourses(List<Course> c);

}

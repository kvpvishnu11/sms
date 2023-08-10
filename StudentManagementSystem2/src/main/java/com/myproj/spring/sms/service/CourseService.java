package com.myproj.spring.sms.service;

/** Service interface that contains contract for Posting courses and getting courses and get course using teacherID **/

import java.util.List;

import com.myproj.spring.sms.entities.Course;

public interface CourseService {
	
	public List<Course> listAllCourses();
	
	public List<Course> postAllCourses(List<Course> c);
	
	public Course getCourseId(long teacherid);

}

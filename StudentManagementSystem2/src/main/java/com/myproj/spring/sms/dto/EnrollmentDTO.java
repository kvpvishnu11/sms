package com.myproj.spring.sms.dto;

import java.util.List;

import com.myproj.spring.sms.entities.Course;

public class EnrollmentDTO {
	
	private long student_id;
	private List<Course> courseList;
	 
	public long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	 
	
	

}

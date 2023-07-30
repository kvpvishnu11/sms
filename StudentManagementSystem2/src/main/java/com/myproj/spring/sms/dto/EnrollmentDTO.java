package com.myproj.spring.sms.dto;

import java.util.List;

import com.myproj.spring.sms.entities.Course;

public class EnrollmentDTO {
	
	private long studentid;
	private List<Course> courseList;
	public long getStudentid() {
		return studentid;
	}
	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	 
	
	

}

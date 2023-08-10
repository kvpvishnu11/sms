package com.myproj.spring.sms.dto;

import java.util.List;

import com.myproj.spring.sms.entities.Course;

/**
 * This DTO is used to process the request for a Post Request in Enrollment
 * Controller
 **/

public class EnrollmentDTO {

	private long student_id;
	private List<Course> courseList;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public long getStudent_id() {
		return student_id;
	}

	public void setStudentId(long student_id) {
		this.student_id = student_id;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

}

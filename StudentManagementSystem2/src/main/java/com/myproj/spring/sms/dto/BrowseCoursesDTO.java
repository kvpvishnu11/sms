package com.myproj.spring.sms.dto;

/**
 * This DTO is used to process the response for a Get Request in Enrollment
 * Controller
 **/

public class BrowseCoursesDTO {

	private long course_id;
	private String course_name;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public long getCourse_id() {
		return course_id;
	}

	public void setCourseId(long course_id) {
		this.course_id = course_id;
	}

	public String getCourseName() {
		return course_name;
	}

	public void setCourseName(String course_name) {
		this.course_name = course_name;
	}

}

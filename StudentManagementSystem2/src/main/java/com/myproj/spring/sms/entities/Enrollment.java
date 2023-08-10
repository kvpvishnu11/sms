package com.myproj.spring.sms.entities;

/** Entity to store the Enrollments information in the database table **/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long enrollment_id;
	private long student_id;
	private long course_id;
	private String course_name;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public long getEnrollment_id() {
		return enrollment_id;
	}

	public void setEnrollment_id(long enrollment_id) {
		this.enrollment_id = enrollment_id;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Enrollment(long enrollment_id, long student_id, long course_id, String course_name) {
		super();
		this.enrollment_id = enrollment_id;
		this.student_id = student_id;
		this.course_id = course_id;
		this.course_name = course_name;
	}

	public Enrollment() {
		super();
	}

}

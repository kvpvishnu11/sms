package com.myproj.spring.sms.entities;

/** Entity to store the Course's information in the database table **/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long course_id;
	private String course_name;
	private String course_credits;
	private int available_seats;
	private long teacher_id;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_credits() {
		return course_credits;
	}

	public void setCourse_credits(String course_credits) {
		this.course_credits = course_credits;
	}

	public int getAvailable_seats() {
		return available_seats;
	}

	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}

	public long getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Course(Long course_id, String course_name, String course_credits, int available_seats, long teacher_id) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_credits = course_credits;
		this.available_seats = available_seats;
		this.teacher_id = teacher_id;
	}

	public Course() {
		super();
	}

}

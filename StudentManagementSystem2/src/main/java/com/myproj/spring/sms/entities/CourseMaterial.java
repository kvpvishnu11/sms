package com.myproj.spring.sms.entities;

/** Entity to store the Course Material information in the database table **/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coursematerial")
public class CourseMaterial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long coursematerial_id;
	private String url;
	private long course_id;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public long getCoursematerial_id() {
		return coursematerial_id;
	}

	public void setCoursematerial_id(long coursematerial_id) {
		this.coursematerial_id = coursematerial_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public CourseMaterial(long coursematerial_id, String url, long course_id) {
		super();
		this.coursematerial_id = coursematerial_id;
		this.url = url;
		this.course_id = course_id;
	}

	public CourseMaterial() {
		super();
	}

}

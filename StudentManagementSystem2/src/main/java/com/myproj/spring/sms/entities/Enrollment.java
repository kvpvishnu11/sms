package com.myproj.spring.sms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long enrollmentid;
	private long studentid;
	private long courseid;
	private String coursename;
	
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public long getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(long enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public long getStudentid() {
		return studentid;
	}
	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}
	public long getCourseid() {
		return courseid;
	}
	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}
	public Enrollment(long enrollmentid, long studentid, long courseid, String coursename) {
		super();
		this.enrollmentid = enrollmentid;
		this.studentid = studentid;
		this.courseid = courseid;
		this.coursename = coursename;
	}
	public Enrollment() {
		super();
	}
	

}

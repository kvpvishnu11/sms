package com.myproj.spring.sms.dto;

import com.myproj.spring.sms.entities.UserLogin;

public class UserDataDTO {

	
	private UserLogin userdata;
	private long studentid;
	private long courseid;
	private long teacherid;
	private String student_course_reg_status;
	private String teachingcourse;
	
	
	
	public String getTeachingcourse() {
		return teachingcourse;
	}
	public void setTeachingcourse(String teachingcourse) {
		this.teachingcourse = teachingcourse;
	}
	public String getStudent_course_reg_status() {
		return student_course_reg_status;
	}
	public void setStudent_course_reg_status(String student_course_reg_status) {
		this.student_course_reg_status = student_course_reg_status;
	}
	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}
	public void setTeacherid(long teacherid) {
		this.teacherid = teacherid;
	}
	public UserLogin getUserdata() {
		return userdata;
	}
	public void setUserdata(UserLogin userdata) {
		this.userdata = userdata;
	}
	public Long getStudentid() {
		return studentid;
	}
	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}
	public Long getCourseid() {
		return courseid;
	}
	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}
	public Long getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Long teacherid) {
		this.teacherid = teacherid;
	}
	
	
	
}

package com.myproj.spring.sms.dto;

import com.myproj.spring.sms.entities.UserLogin;

public class UserDataDTO {

	
	private UserLogin userdata;
	private long student_id;
	private long course_id;
	private long teacher_id;
	private String student_course_reg_status;
	private String teaching_course;
	public UserLogin getUserdata() {
		return userdata;
	}
	public void setUserdata(UserLogin userdata) {
		this.userdata = userdata;
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
	public long getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(long teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getStudent_course_reg_status() {
		return student_course_reg_status;
	}
	public void setStudent_course_reg_status(String student_course_reg_status) {
		this.student_course_reg_status = student_course_reg_status;
	}
	public String getTeaching_course() {
		return teaching_course;
	}
	public void setTeaching_course(String teaching_course) {
		this.teaching_course = teaching_course;
	}
	public UserDataDTO(UserLogin userdata, long student_id, long course_id, long teacher_id,
			String student_course_reg_status, String teaching_course) {
		super();
		this.userdata = userdata;
		this.student_id = student_id;
		this.course_id = course_id;
		this.teacher_id = teacher_id;
		this.student_course_reg_status = student_course_reg_status;
		this.teaching_course = teaching_course;
	}
	public UserDataDTO() {
		super();
	}
	
	
	
	 
	
	
	
}

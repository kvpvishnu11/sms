package com.myproj.spring.sms.dto;

/** This is a DTO used to return from an Post Service in User Login controller **/
/** Useful for getting student registration status and other user details */

import com.myproj.spring.sms.entities.UserLogin;

public class UserDataDTO {

	private UserLogin userdata;
	private long student_id;
	private long course_id;
	private long teacher_id;
	private String student_course_reg_status;
	private String teaching_course;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public UserLogin getUserdata() {
		return userdata;
	}

	public void setUserdata(UserLogin userdata) {
		this.userdata = userdata;
	}

	public long getStudentId() {
		return student_id;
	}

	public void setStudentId(long student_id) {
		this.student_id = student_id;
	}

	public long getCourseId() {
		return course_id;
	}

	public void setCourseId(long course_id) {
		this.course_id = course_id;
	}

	public long getTeacherId() {
		return teacher_id;
	}

	public void setTeacherId(long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getStudentCourseRegStatus() {
		return student_course_reg_status;
	}

	public void setStudentCourseRegStatus(String student_course_reg_status) {
		this.student_course_reg_status = student_course_reg_status;
	}

	public String getTeachingCourse() {
		return teaching_course;
	}

	public void setTeachingCourse(String teaching_course) {
		this.teaching_course = teaching_course;
	}

	/** Default and all elements embedded constructors **/

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

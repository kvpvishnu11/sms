package com.myproj.spring.sms.dto;

/** This is a class implementing the projection interface **/
/** Used to handle the response received from the Teacher repository in the Teacher repository **/
/**
 * Used to get all the teachers in the system and display in Admin portal so
 * that he can map them to courses
 **/

public class TeacherListDTOImpl implements TeacherListDTO {

	private Long teacher_id;
	private String first_name;
	private String last_name;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public Long getTeacherId() {
		return teacher_id;
	}

	public void setTeacherId(Long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public TeacherListDTOImpl(Long teacher_id, String first_name, String last_name) {
		super();
		this.teacher_id = teacher_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public TeacherListDTOImpl() {
		super();
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

}

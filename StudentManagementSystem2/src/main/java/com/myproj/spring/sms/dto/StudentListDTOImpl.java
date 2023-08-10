package com.myproj.spring.sms.dto;

/** This is a class implementing the projection Interface **/
/** This DTO is used to process the response for a Get Request in Teacher Controller **/
/** Used to display the students enrolled in a particular teacher's course **/

public class StudentListDTOImpl implements StudentListDTO {
	private Long student_id;
	private String first_name;
	private String last_name;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public Long getStudentId() {
		return student_id;
	}

	public void setStudentId(Long student_id) {
		this.student_id = student_id;
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

	public StudentListDTOImpl(Long student_id, String first_name, String last_name) {
		super();
		this.student_id = student_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

}

package com.myproj.spring.sms.dto;

/** This is a Projection Interface **/
/** This DTO is used to process the response for a Get Request in Teacher Controller **/
/** Used to display the students enrolled in a particular teacher's course **/

public interface StudentListDTO {
	Long getStudentId();

	String getFirstName();

	String getLastName();

}

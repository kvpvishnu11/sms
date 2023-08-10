package com.myproj.spring.sms.dto;

/** This is a Projection interface **/
/** Used to handle the response received from the Teacher repository in the Teacher repository **/
/**
 * Used to get all the teachers in the system and display in Admin portal so
 * that he can map them to courses
 **/

public interface TeacherListDTO {

	Long getTeacherId();

	String getFirstName();

	String getLastName();
}

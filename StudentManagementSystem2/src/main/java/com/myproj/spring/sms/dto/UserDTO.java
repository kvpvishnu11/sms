package com.myproj.spring.sms.dto;

/** DTO used to process the POST request in User Login Controller **/
/** Used for processing username and password in Post request **/

public class UserDTO {

	private String username;
	private String password;
	private String role;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

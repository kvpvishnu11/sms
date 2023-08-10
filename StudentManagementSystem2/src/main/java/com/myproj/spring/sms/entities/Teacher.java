package com.myproj.spring.sms.entities;

/** Entity to store the Teacher related information in the database table **/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teacher_id;
	private long user_id;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public long getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public Teacher(long teacher_id, long user_id) {
		super();
		this.teacher_id = teacher_id;
		this.user_id = user_id;
	}

	public Teacher() {
		super();
	}

}

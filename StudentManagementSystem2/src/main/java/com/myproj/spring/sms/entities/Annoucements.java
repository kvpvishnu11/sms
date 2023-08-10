package com.myproj.spring.sms.entities;

/** Entity to store the Announcements information in the database table **/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Annoucements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long annoucement_id;
	private String annoucement_note;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public long getAnnoucement_id() {
		return annoucement_id;
	}

	public void setAnnoucement_id(long annoucement_id) {
		this.annoucement_id = annoucement_id;
	}

	public String getAnnoucement_note() {
		return annoucement_note;
	}

	public void setAnnoucement_note(String annoucement_note) {
		this.annoucement_note = annoucement_note;
	}

	public Annoucements(long annoucement_id, String annoucement_note) {
		super();
		this.annoucement_id = annoucement_id;
		this.annoucement_note = annoucement_note;
	}

	public Annoucements() {
		super();
	}

}

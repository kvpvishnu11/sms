package com.myproj.spring.sms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Annoucements {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long annoucementid;
	private String annoucementnote;
	public long getAnnoucementid() {
		return annoucementid;
	}
	public void setAnnoucementid(long annoucementid) {
		this.annoucementid = annoucementid;
	}
	public String getAnnoucementnote() {
		return annoucementnote;
	}
	public void setAnnoucementnote(String annoucementnote) {
		this.annoucementnote = annoucementnote;
	}
	
}

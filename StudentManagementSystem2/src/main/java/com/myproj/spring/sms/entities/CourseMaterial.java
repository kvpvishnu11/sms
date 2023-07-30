package com.myproj.spring.sms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="coursematerial")
public class CourseMaterial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long coursematerialid;
	private String url;
	private long courseid;
	public long getCoursematerialid() {
		return coursematerialid;
	}
	public void setCoursematerialid(long coursematerialid) {
		this.coursematerialid = coursematerialid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getCourseid() {
		return courseid;
	}
	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}
	
	

}

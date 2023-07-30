package com.myproj.spring.sms.service;

import java.util.List;

import com.myproj.spring.sms.entities.CourseMaterial;

public interface CourseMaterialService {
	
	public CourseMaterial postNewMaterial(CourseMaterial cm);
	
	public List<CourseMaterial> getCourseMaterial(long id);
	
	 

}

package com.myproj.spring.sms.service;

/** Service interface that contains contract for Posting new material and getting course material **/

import java.util.List;

import com.myproj.spring.sms.entities.CourseMaterial;

public interface CourseMaterialService {
	
	public CourseMaterial postNewMaterial(CourseMaterial cm);
	
	public List<CourseMaterial> getCourseMaterial(long id);
	
	 

}

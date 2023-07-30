package com.myproj.spring.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.entities.CourseMaterial;
import com.myproj.spring.sms.repositories.CourseMaterialRepository;

@Component
public class CourseMaterialImpl implements CourseMaterialService {
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	@Override
	public CourseMaterial postNewMaterial(CourseMaterial cm) {
		 
		return courseMaterialRepository.save(cm);
	}

	@Override
	public List<CourseMaterial> getCourseMaterial(long id) {
		 
		return courseMaterialRepository.getByCourseID(id);
	
	

}
}

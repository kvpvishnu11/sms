package com.myproj.spring.sms.service;

/** Implementing the methods that performs business logic and CRUD operations of Course Material Service Interface **/
/** Implements operations to get list of courses material, post all new courses new course material to DB **/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.entities.CourseMaterial;
import com.myproj.spring.sms.repositories.CourseMaterialRepository;

import jakarta.transaction.Transactional;

@Component
public class CourseMaterialImpl implements CourseMaterialService {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	/** Save all the new course material **/
	@Transactional
	@Override
	public CourseMaterial postNewMaterial(CourseMaterial cm) {

		return courseMaterialRepository.save(cm);
	}

	/** Get all the existing course material **/
	@Override
	public List<CourseMaterial> getCourseMaterial(long id) {

		return courseMaterialRepository.getByCourseID(id);

	}
}

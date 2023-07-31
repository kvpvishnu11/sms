package com.myproj.spring.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.repositories.CourseRepository;

import jakarta.transaction.Transactional;

@Component
public class CourseImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Override
	public List<Course> listAllCourses() {
		 
		return courseRepository.findAll();
	}
	
	@Transactional
	@Override
	public List<Course> postAllCourses(List<Course> c) {
		 
		return courseRepository.saveAll(c);
	}

	@Override
	public Course getCourseId(long teacherid) {
		 
		return courseRepository.findByTeacherid(teacherid);
	}
	

}

package com.myproj.spring.sms.service;

/** Implementing the methods that performs business logic and CRUD operations of Course Service Interface **/
/** Implements operations to get list of courses, post all new courses and get Teacher by Course ID from DB **/

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

	/** Save all the new courses **/
	@Transactional
	@Override
	public List<Course> postAllCourses(List<Course> c) {

		return courseRepository.saveAll(c);
	}

	/** Get all the existing courses using teacher id **/

	@Override
	public Course getCourseId(long teacherid) {

		return courseRepository.findByTeacherid(teacherid);
	}

}

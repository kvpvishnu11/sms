package com.myproj.spring.sms.repositories;

/** Repository to handle the CRUD Operations of Course Controller **/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproj.spring.sms.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	/** Method to fetch the course using teacher ID. This acts like a native sql query **/

	@Query(value = "SELECT * FROM course WHERE teacher_id = :id", nativeQuery = true)
	public Course findByTeacherid(long id);

}

package com.myproj.spring.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproj.spring.sms.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	@Query(value = "SELECT * FROM course WHERE teacherid = :id", nativeQuery = true)
	public Course findByTeacherid(long id);

}

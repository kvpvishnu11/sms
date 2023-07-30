package com.myproj.spring.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproj.spring.sms.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

package com.myproj.spring.sms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproj.spring.sms.dto.BrowseCoursesDTO;
import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

	//@Query("SELECT e.courseid, e.coursename FROM Enrollment e WHERE e.studentid = :studentId")
	public List<Enrollment> findAllByStudentid(@Param("studentId") Long studentId);
	 
}





package com.myproj.spring.sms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproj.spring.sms.dto.BrowseCoursesDTO;
import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.entities.Enrollment;
import com.myproj.spring.sms.entities.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

	@Query(value = "SELECT * FROM enrollment WHERE student_id = :studentId", nativeQuery = true)
	public List<Enrollment> findAllByStudentid(@Param("studentId") Long studentId);

	 
}





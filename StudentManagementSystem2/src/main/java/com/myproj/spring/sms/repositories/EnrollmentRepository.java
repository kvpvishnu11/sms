package com.myproj.spring.sms.repositories;

/** Repository to handle the CRUD Operations of Enrollment Controller **/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproj.spring.sms.dto.BrowseCoursesDTO;
import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.entities.Enrollment;
import com.myproj.spring.sms.entities.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

	/** Method to fetch all the courses enrolled using student ID. This acts like a native sql query **/

	@Query(value = "SELECT * FROM enrollment WHERE student_id = :studentId", nativeQuery = true)
	public List<Enrollment> findAllByStudentid(@Param("studentId") Long studentId);

	 
}





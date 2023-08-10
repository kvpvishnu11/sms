package com.myproj.spring.sms.repositories;

/** Repository to handle the CRUD Operations of Student Controller **/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproj.spring.sms.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	/** Method to fetch the Student details using user ID. This acts like a native sql query **/
	@Query(value = "SELECT * FROM student WHERE user_id = :id", nativeQuery = true)
	public Student findByStudentid(Long id);
	
	
	
}

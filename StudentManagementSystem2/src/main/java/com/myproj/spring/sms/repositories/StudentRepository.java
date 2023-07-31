package com.myproj.spring.sms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproj.spring.sms.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(value = "SELECT * FROM student WHERE userid = :id", nativeQuery = true)
	public Student findByStudentid(Long id);
	
	
	
}

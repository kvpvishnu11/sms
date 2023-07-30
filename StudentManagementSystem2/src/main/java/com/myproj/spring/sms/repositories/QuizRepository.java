package com.myproj.spring.sms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproj.spring.sms.entities.CourseMaterial;
import com.myproj.spring.sms.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	
	 @Query(value = "SELECT * FROM quiz WHERE courseid = :courseid", nativeQuery = true)
	    public List<Quiz> getQuizQuestions(@Param("courseid") long courseid);

}

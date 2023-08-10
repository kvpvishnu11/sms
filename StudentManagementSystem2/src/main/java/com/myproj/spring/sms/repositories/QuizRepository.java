package com.myproj.spring.sms.repositories;

/** Repository to handle the CRUD Operations of Quiz Controller **/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproj.spring.sms.entities.CourseMaterial;
import com.myproj.spring.sms.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	
	/** Method to fetch the quiz using course ID. This acts like a native sql query **/

	
	 @Query(value = "SELECT * FROM quiz WHERE course_id = :courseid", nativeQuery = true)
	    public List<Quiz> getQuizQuestions(@Param("courseid") long courseid);
	 
	 
	/** Method to delete the quiz using course ID. This acts like a native sql query **/
	
	 @Modifying
	 @Query(value = "DELETE FROM quiz WHERE course_id = :courseid", nativeQuery = true)
	 void deleteQuizQuestionsByCourseId(@Param("courseid") long courseid);


}

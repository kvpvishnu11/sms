package com.myproj.spring.sms.repositories;

/** Repository to handle the CRUD Operations of Course Material Controller **/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproj.spring.sms.entities.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
	
	
	/** Method to fetch the course material using course ID. This acts like a native sql query **/
	
	  @Query(value = "SELECT * FROM coursematerial WHERE course_id = :courseid", nativeQuery = true)
	    public List<CourseMaterial> getByCourseID(@Param("courseid") long courseid);

}

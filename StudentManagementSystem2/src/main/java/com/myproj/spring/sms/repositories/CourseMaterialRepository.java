package com.myproj.spring.sms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproj.spring.sms.entities.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
	
	
	  @Query(value = "SELECT * FROM coursematerial WHERE courseid = :courseid", nativeQuery = true)
	    public List<CourseMaterial> getByCourseID(@Param("courseid") long courseid);

}

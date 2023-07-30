package com.myproj.spring.sms.service;

import java.util.List;

import com.myproj.spring.sms.dto.BrowseCoursesDTO;
import com.myproj.spring.sms.dto.EnrollmentDTO;
import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.entities.Enrollment;

public interface EnrollmentService {
	
	public EnrollmentDTO saveEnrollments(EnrollmentDTO e);
	
	public List<Enrollment> listAllCoursesByStudentID(long student_id);
}

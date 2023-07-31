package com.myproj.spring.sms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.dto.BrowseCoursesDTO;
import com.myproj.spring.sms.dto.EnrollmentDTO;
import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.entities.Enrollment;
import com.myproj.spring.sms.repositories.CourseRepository;
import com.myproj.spring.sms.repositories.EnrollmentRepository;

import jakarta.transaction.Transactional;

@Component
public class EnrollmentImpl implements EnrollmentService {
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	 
	@Transactional
	@Override
	public EnrollmentDTO saveEnrollments(EnrollmentDTO e) {
		
		List<Course> courseNames = e.getCourseList();
		long student_id = e.getStudentid();

		// SAVE MULTIPLE ENROLLMENTS FOR THE SAME STUDENT
		for (Course course : courseNames) {

		    Enrollment enrollment = new Enrollment();

		    enrollment.setStudentid(student_id);
		    enrollment.setCourseid(course.getCourseid());
		    enrollment.setCoursename(course.getCoursename()); // Set the course name
		    enrollmentRepository.save(enrollment);

		    Course c1 = courseRepository.findById(course.getCourseid()).orElse(null);
		    if (c1 != null) {

		        if (c1.getAvailableseats() > 0) {
		            c1.setAvailableseats(c1.getAvailableseats() - 1);
		            courseRepository.save(c1);
		        }
		    }
		}

		
		return e;
	}

	 

	@Override
	public List<Enrollment> listAllCoursesByStudentID(long studentId) {
		 //System.out.println("Querying enrollments for student ID: " + studentId);
		    List<Enrollment> enrolmentdata = enrollmentRepository.findAllByStudentid(studentId);
		 //   System.out.println("Enrollments found: " + enrolmentdata);
		    return enrolmentdata;
	}


	 

}

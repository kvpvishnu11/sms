package com.myproj.spring.sms.service;

/** Class that implements Enrollment service interface methods **/
/** Used to perform CRUD operations and get list of enrollments for a student and save new enrollments for students **/

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

	/** Save all the new course enrollments done by a student **/
	@Transactional
	@Override
	public EnrollmentDTO saveEnrollments(EnrollmentDTO e) {

		List<Course> courseNames = e.getCourseList();
		long student_id = e.getStudent_id();

		// SAVE MULTIPLE ENROLLMENTS FOR THE SAME STUDENT
		for (Course course : courseNames) {

			Enrollment enrollment = new Enrollment();

			enrollment.setStudent_id(student_id);
			enrollment.setCourse_id(course.getCourse_id());
			enrollment.setCourse_name(course.getCourse_name()); // Set the course name
			enrollmentRepository.save(enrollment);

			Course c1 = courseRepository.findById(course.getCourse_id()).orElse(null);
			if (c1 != null) {

				if (c1.getAvailable_seats() > 0) {
					c1.setAvailable_seats(c1.getAvailable_seats() - 1);
					courseRepository.save(c1);
				}
			}
		}

		return e;
	}

	/** List down all the new enrollments for a student **/

	@Override
	public List<Enrollment> listAllCoursesByStudentID(long studentId) {

		List<Enrollment> enrolmentdata = enrollmentRepository.findAllByStudentid(studentId);

		return enrolmentdata;
	}

}

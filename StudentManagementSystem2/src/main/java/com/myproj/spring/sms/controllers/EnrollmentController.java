package com.myproj.spring.sms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.dto.BrowseCoursesDTO;
import com.myproj.spring.sms.dto.EnrollmentDTO;
import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.entities.Enrollment;
import com.myproj.spring.sms.service.EnrollmentService;

/**
 * This controller handles the requests to save the new enrollments and browse a
 * particular student enrollments
 **/

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrollmentService;

	/** Saving new enrollments which are done by a Student during registration **/
	@PostMapping("/save")
	public ResponseEntity<?> saveAllEnrollments(@RequestBody EnrollmentDTO e) {
		if (e == null) {
			return ResponseEntity.badRequest().body("Request body is empty.");
		} else {
			EnrollmentDTO savedEnrollment = enrollmentService.saveEnrollments(e);
			return ResponseEntity.ok(savedEnrollment);
		}
	}

	// Browsing the courses using the student id
	@GetMapping("/browse/{student_id}")
	public ResponseEntity<?> browseEnrollments(@PathVariable("student_id") long student_id) {
		if (student_id <= 0) {
			return ResponseEntity.badRequest().body("Invalid Student ID.");
		} else {
			List<Enrollment> originalEnrollments = enrollmentService.listAllCoursesByStudentID(student_id);

			if (originalEnrollments.isEmpty()) {
				return ResponseEntity.ok("No courses found for the given student id.");
			} else {
				List<BrowseCoursesDTO> filteredCourses = new ArrayList<>();

				for (Enrollment enrollment : originalEnrollments) {
					BrowseCoursesDTO filteredCourse = new BrowseCoursesDTO();
					filteredCourse.setCourseId(enrollment.getCourse_id());
					filteredCourse.setCourseName(enrollment.getCourse_name());
					filteredCourses.add(filteredCourse);
				}

				return ResponseEntity.ok(filteredCourses);
			}
		}
	}
}

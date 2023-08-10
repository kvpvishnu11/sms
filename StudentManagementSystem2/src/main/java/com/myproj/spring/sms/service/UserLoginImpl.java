package com.myproj.spring.sms.service;

/** Implementation class for User Login Service interface **/
/** Contains logic for saving newly signed up user, checking if user exists in DB, displaying user's profile **/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.dto.UserDataDTO;
import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.entities.Enrollment;
import com.myproj.spring.sms.entities.Student;
import com.myproj.spring.sms.entities.Teacher;
import com.myproj.spring.sms.entities.UserLogin;
import com.myproj.spring.sms.repositories.UserLoginRepository;

import jakarta.transaction.Transactional;

@Component
public class UserLoginImpl implements UserLoginService {

	@Autowired
	private UserLoginRepository userLoginRepository;

	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private EnrollmentService enrollmentService;

	/** To save a new User into the DB **/
	@Transactional
	@Override
	public UserLogin saveTheNewUser(UserLogin u) {
		return userLoginRepository.save(u);
	}

	/** Get the User details using their user name **/
	@Override
	public UserLogin getByUsername(String username) {
		return userLoginRepository.findByUsername(username);
	}

	/** Update the user details information **/
	@Transactional
	@Override
	public UserLogin updateUserData(UserLogin u) {
		return userLoginRepository.save(u);
	}

	/** Find the user using user name and password **/
	@Override
	public UserLogin findByUsernameAndPassword(String username, String password) {
		return userLoginRepository.findByUsernameAndPassword(username, password);
	}

	/** Find the user using a user name **/

	@Override
	public UserLogin findUser(String username) {
		return userLoginRepository.findByUname(username);
	}

	/** Sign up a new User **/
	@Override
	public UserLogin newUserSignUp(UserLogin u) {
		// New User Sign up
		// Save into Teacher table if the role is teacher
		// Save into Student table if the role is student

		UserLogin newUser = userLoginRepository.save(u);

		if (u.getRole().equalsIgnoreCase("teacher")) {
			Teacher t1 = new Teacher();
			t1.setUser_id(newUser.getUser_id());
			teacherService.saveTheNewTeacher(t1);
		} else if (u.getRole().equalsIgnoreCase("student")) {
			Student s1 = new Student();
			s1.setUser_id(newUser.getUser_id());
			studentService.saveTheNewStudent(s1);
		}

		return newUser;
	}

	/** Check if user exists or not logic **/
	@Override
	public UserDataDTO processUserData(UserLogin user) {
		UserDataDTO finalUserData = new UserDataDTO();
		finalUserData.setUserdata(user);

		if (user.getRole().equalsIgnoreCase("student")) {
			Student studentdata = studentService.findStudentUsingID(user.getUser_id());
			System.out.println("Student id = " + studentdata.getStudent_id());
			List<Enrollment> enrolmentdata = enrollmentService.listAllCoursesByStudentID(studentdata.getStudent_id());

			System.out.println("\n size = " + enrolmentdata.size());

			finalUserData.setStudentId(studentdata.getStudent_id());
			if (enrolmentdata.size() > 0) {
				finalUserData.setStudentCourseRegStatus("true");
			} else {
				finalUserData.setStudentCourseRegStatus("false");
			}

		} else if (user.getRole().equalsIgnoreCase("teacher")) {
			Teacher teacherdata = teacherService.findTeacherUsingID(user.getUser_id());
			Course coursedata = courseService.getCourseId(teacherdata.getTeacher_id());

			finalUserData.setTeacherId(teacherdata.getTeacher_id());

			if (coursedata != null) {
				finalUserData.setCourseId(coursedata.getCourse_id());
				finalUserData.setTeachingCourse(coursedata.getCourse_name());
			}
		}

		return finalUserData;
	}

}

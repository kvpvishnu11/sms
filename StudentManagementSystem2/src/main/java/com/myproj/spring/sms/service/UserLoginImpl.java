package com.myproj.spring.sms.service;

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

	@Transactional
	@Override
	public UserLogin saveTheNewUser(UserLogin u) {
		return userLoginRepository.save(u);
	}

	@Override
	public UserLogin getByUsername(String username) {
		return userLoginRepository.findByUsername(username);
	}

	@Transactional
	@Override
	public UserLogin updateUserData(UserLogin u) {
		return userLoginRepository.save(u);
	}

	@Override
	public UserLogin findByUsernameAndPassword(String username, String password) {
		return userLoginRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public UserLogin findUser(String username) {
		return userLoginRepository.findByUname(username);
	}

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

	@Override
	public UserDataDTO processUserData(UserLogin user) {
		UserDataDTO finalUserData = new UserDataDTO();
		finalUserData.setUserdata(user);

		if (user.getRole().equalsIgnoreCase("student")) {
			Student studentdata = studentService.findStudentUsingID(user.getUser_id());
			System.out.println("Student id = " + studentdata.getStudent_id());
			List<Enrollment> enrolmentdata = enrollmentService.listAllCoursesByStudentID(studentdata.getStudent_id());

			System.out.println("\n size = " + enrolmentdata.size());

			finalUserData.setStudent_id(studentdata.getStudent_id());
			if (enrolmentdata.size() > 0) {
				finalUserData.setStudent_course_reg_status("true");
			} else {
				finalUserData.setStudent_course_reg_status("false");
			}

		} else if (user.getRole().equalsIgnoreCase("teacher")) {
			Teacher teacherdata = teacherService.findTeacherUsingID(user.getUser_id());
			Course coursedata = courseService.getCourseId(teacherdata.getTeacher_id());

			finalUserData.setTeacher_id(teacherdata.getTeacher_id());

			if (coursedata != null) {
				finalUserData.setCourse_id(coursedata.getCourse_id());
				finalUserData.setTeaching_course(coursedata.getCourse_name());
			}
		}

		return finalUserData;
	}

}

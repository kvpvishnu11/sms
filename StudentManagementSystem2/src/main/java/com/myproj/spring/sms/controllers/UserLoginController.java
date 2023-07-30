package com.myproj.spring.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.dto.UserDTO;
import com.myproj.spring.sms.entities.Student;
import com.myproj.spring.sms.entities.Teacher;
import com.myproj.spring.sms.entities.UserLogin;
import com.myproj.spring.sms.service.StudentService;
import com.myproj.spring.sms.service.TeacherService;
import com.myproj.spring.sms.service.UserLoginService;

@RestController
@RequestMapping("/userlogin")
public class UserLoginController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	
	// Create and handle the methods needed for the application
	
	// NEW USER SIGN UP
	@PostMapping("/signupuser")
	public ResponseEntity<?>  saveNewUserSignup(@RequestBody UserLogin u) {
		
		String usernamecheck = u.getUsername();
		
		
		if(userLoginService.findUser(usernamecheck)==null) {
		
		UserLogin u1 = userLoginService.saveTheNewUser(u);
		
		// Save into Teacher table also if the role is "teacher"
		
		if(u.getRole().equalsIgnoreCase("teacher")) {
			
			Teacher t1 = new Teacher();
			t1.setUserid(u.getUserid());			
			teacherService.saveTheNewTeacher(t1);	
			
		}
		
		// Save into Student table also if the role is "student"
		
		if(u.getRole().equalsIgnoreCase("student")) {
			
			Student s1 = new Student();
			s1.setUserid(u.getUserid());			
			studentService.saveTheNewStudent(s1);	
			
		}
		
		return ResponseEntity.ok(u1);
	}else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username already exists.");

	}
	}
	
	// VALIDATE USERNAME AND PASSWORD
	
	/*
	
	@PostMapping("/checkuser")
	public ResponseEntity<?> checkIfUserIsPresent(@RequestBody UserDTO u) {
	    UserLogin user = userLoginService.findByUsernameAndPasswordAndRole(u.getUsername(), u.getPassword(),u.getRole());
	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User doesn't exist");
	    } else {
	        return ResponseEntity.ok(user);
	    }
	}
	*/
	
	@PostMapping("/checkuser")
	public ResponseEntity<?> checkIfUserIsPresent(@RequestBody UserDTO u) {
	    UserLogin user = userLoginService.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User doesn't exist");
	    } else {
	        return ResponseEntity.ok(user);
	    }
	}
	
	// Get User Details For Viewing and Modification purposes if any
	
	@GetMapping("/displayuser/{uname}")
	public UserLogin getUserDetails(@PathVariable("uname") String username) {
		
		UserLogin u2 = userLoginService.getByUsername(username);
		if(u2==null) {
			System.out.println("No user");
		}else {
			System.out.println(u2.getFirstname());
		}
		return u2;
	}
	
	// Updated the Modified details in the database
	
	@PutMapping("/updateuser")
	public UserLogin updateUserDetails(@RequestBody UserLogin u) {
		
		UserLogin u1 = userLoginService.updateUserData(u);
		
		return u1;
		
	}
	
	

}

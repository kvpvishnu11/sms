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
import com.myproj.spring.sms.dto.UserDataDTO;
 import com.myproj.spring.sms.entities.UserLogin;
import com.myproj.spring.sms.service.UserLoginService;

@RestController
@RequestMapping("/userlogin")
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;

	@PostMapping("/signupuser")
	public ResponseEntity<?> saveNewUserSignup(@RequestBody UserLogin u) {

	    // Validate user input request
	    if (u.getUsername() == null || u.getUsername().isEmpty() ||
	        u.getPassword() == null || u.getPassword().isEmpty() ||
	        u.getRole() == null || u.getRole().isEmpty()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check the request JSON. Username/Password/Role is missing.");
	    }

	    // Check if the user name already exists
	    if (userLoginService.findUser(u.getUsername()) != null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists.");
	    }

	    // Save the new user
	    UserLogin newUser = userLoginService.newUserSignUp(u);

	    if (newUser != null) {
	        return ResponseEntity.ok(newUser);
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the new user.");
	    }
	}

	// VALIDATE USERNAME AND PASSWORD

	@PostMapping("/checkuser")
	public ResponseEntity<?> checkIfUserIsPresent(@RequestBody UserDTO u) {
	    // Validate Input request
	    if (u.getUsername() == null || u.getUsername().isEmpty() || u.getPassword() == null || u.getPassword().isEmpty()) {
	        System.out.println("In if ");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check the request JSON. Username/Password is missing.");
	    }

	    // Check if the user exists
	    UserLogin user = userLoginService.findByUsernameAndPassword(u.getUsername(), u.getPassword());

	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User doesn't exist");
	    }

	    // Calling a method in service layer to process user data and role
	    UserDataDTO userData = userLoginService.processUserData(user);
	    return ResponseEntity.ok(userData);
	}


	// Get User Details For Viewing and Modification purposes if any

	@GetMapping("/displayuser/{uname}")
	public ResponseEntity<?> getUserDetails(@PathVariable("uname") String username) {
		
		if(username==null|| username.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please check the JSON request. Username is empty.");
		}

		UserLogin u2 = userLoginService.getByUsername(username);
		if (u2 == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such user in the system.");

		} else {
			System.out.println(u2.getFirst_name());
		}
		return ResponseEntity.ok(u2);
	}

	// Updated the Modified details in the database

	@PutMapping("/updateuser")
	public UserLogin updateUserDetails(@RequestBody UserLogin u) {

		UserLogin u1 = userLoginService.updateUserData(u);

		return u1;

	}

}

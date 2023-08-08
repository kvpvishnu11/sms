package com.myproj.spring.sms.service;

import com.myproj.spring.sms.dto.UserDTO;
import com.myproj.spring.sms.dto.UserDataDTO;
import com.myproj.spring.sms.entities.UserLogin;
 
public interface UserLoginService {
	
	public UserLogin saveTheNewUser(UserLogin u);
	
	// public UserLogin findByUsernameAndPasswordAndRole(String username, String password,String role);
	
	public UserLogin findByUsernameAndPassword(String username, String password);
	
	public UserLogin getByUsername(String username);
	
	public UserLogin updateUserData(UserLogin u);
	
	public UserLogin findUser(String username);
	
	public UserLogin newUserSignUp(UserLogin u);
	
	public UserDataDTO processUserData(UserLogin u);

}

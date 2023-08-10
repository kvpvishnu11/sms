package com.myproj.spring.sms.service;

/** Service interface for UserLogin Controller **/
/** Contains methods for saving newly signed up user, checking if user exists in DB, displaying user's profile **/

import com.myproj.spring.sms.dto.UserDTO;
import com.myproj.spring.sms.dto.UserDataDTO;
import com.myproj.spring.sms.entities.UserLogin;
 
public interface UserLoginService {
	
	public UserLogin saveTheNewUser(UserLogin u);
	
	public UserLogin findByUsernameAndPassword(String username, String password);
	
	public UserLogin getByUsername(String username);
	
	public UserLogin updateUserData(UserLogin u);
	
	public UserLogin findUser(String username);
	
	public UserLogin newUserSignUp(UserLogin u);
	
	public UserDataDTO processUserData(UserLogin u);

}

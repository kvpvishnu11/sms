package com.myproj.spring.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.entities.UserLogin;
import com.myproj.spring.sms.repositories.UserLoginRepository;

@Component
public class UserLoginImpl implements UserLoginService {
	
	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Override
	public UserLogin saveTheNewUser(UserLogin u) {
		 
		return userLoginRepository.save(u);
	}

//	@Override
//	public UserLogin findByUsernameAndPasswordAndRole(String username, String password, String role) {
//		 
//		return userLoginRepository.findByUsernameAndPasswordAndRole(username, password, role);
//	}

	@Override
	public UserLogin getByUsername(String username) {
		 
		return userLoginRepository.findByUsername(username);
	}

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

}

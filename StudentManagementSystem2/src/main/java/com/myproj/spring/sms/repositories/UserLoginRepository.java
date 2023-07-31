package com.myproj.spring.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproj.spring.sms.entities.UserLogin;
 
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
	
	/*
	@Query(value = "SELECT * FROM UserLogin WHERE username = :username AND password = :password AND role = :role", nativeQuery = true)
	public UserLogin findByUsernameAndPasswordAndRole(String username, String password, String role);
	*/
	
	@Query(value = "SELECT * FROM user_login WHERE username = :username AND password = :password", nativeQuery = true)
	public UserLogin findByUsernameAndPassword(String username, String password);
	
	public UserLogin findByUsername(@Param("username") String username);
	
	@Query(value = "SELECT * FROM user_login WHERE username = :username", nativeQuery = true)
	public UserLogin findByUname(String username);
	
	
}

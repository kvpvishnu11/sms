package com.myproj.spring.sms.repositories;

/** Repository to handle the CRUD Operations of UserLogin Controller **/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproj.spring.sms.entities.UserLogin;
 
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
	
	/** Query to search the DB using username and password**/
	@Query(value = "SELECT * FROM user_login WHERE username = :username AND password = :password", nativeQuery = true)
	public UserLogin findByUsernameAndPassword(String username, String password);
	
	/** Query to Search db using username. This is to display user profile.**/
	public UserLogin findByUsername(@Param("username") String username);
	
	/** Query to Search db using username. This is to display user profile.**/
	@Query(value = "SELECT * FROM user_login WHERE username = :username", nativeQuery = true)
	public UserLogin findByUname(String username);
	
	
}

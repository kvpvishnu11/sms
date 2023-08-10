package com.myproj.spring.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproj.spring.sms.controllers.UserLoginController;
import com.myproj.spring.sms.entities.UserLogin;
import com.myproj.spring.sms.service.CourseService;
import com.myproj.spring.sms.service.EnrollmentService;
import com.myproj.spring.sms.service.StudentService;
import com.myproj.spring.sms.service.TeacherService;
import com.myproj.spring.sms.service.UserLoginService;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserLoginController.class)
public class UserLoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserLoginService userLoginService;
    
    @MockBean
    private StudentService studentService;
    
    @MockBean
    private TeacherService teacherService;
    
    @MockBean
    private CourseService courseService;
    
    @MockBean
    private EnrollmentService enrollmentService;
    
    // We are Following 3 steps in every test case here
    // Preparing the test data for my service method 
    // Mocking my service method
    // Comparing the result 


    
    /** Testing to display the user details using username **/
    @Test
    public void testGetUserDetails() throws Exception {
        // Prepare test data
        UserLogin user = new UserLogin(1, "testuser", "testpwd", "avinash", "kun", "1234567890",
                "avi.soe@example.com", "student");

        // Mock the behavior  
        when(userLoginService.getByUsername("testuser")).thenReturn(user);

        // Perform the GET request  
        mockMvc.perform(MockMvcRequestBuilders.get("/userlogin/displayuser/{uname}", "testuser"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"user_id\":1,\"username\":\"testuser\",\"password\":\"testpwd\",\"first_name\":\"avinash\",\"last_name\":\"kun\",\"phone_no\":\"1234567890\",\"email\":\"avi.soe@example.com\",\"role\":\"student\"}"));
    }

    /** Testing if the user details can be updated **/
    @Test
    public void testUpdateUserDetails() throws Exception {
        // Prepare test data
        UserLogin existingUser = new UserLogin(1, "testuser", "testpwd", "avinash", "kun", "1234567890",
                "avi.ko@.com", "student");

        // Mock the behavior  
        Mockito.when(userLoginService.updateUserData(Mockito.any(UserLogin.class))).thenReturn(existingUser);

        // Perform the PUT request  
        mockMvc.perform(MockMvcRequestBuilders.put("/userlogin/updateuser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(existingUser)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value(existingUser.getUsername()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(existingUser.getEmail()));
    }
    
    /** Testing for signing up a new user **/
    @Test
    public void testSaveNewUserSignup() throws Exception {
        // Prepare test data for the request
        UserLogin newUser = new UserLogin();
        newUser.setUsername("newuser");
        newUser.setPassword("newpassword");
        newUser.setRole("student");

        // Mock the behavior for checking if the username exists
        when(userLoginService.findUser("newuser")).thenReturn(null);

        // Mock the behavior for saving the new user
        when(userLoginService.newUserSignUp(Mockito.any(UserLogin.class))).thenReturn(newUser);

        // Perform the POST request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.post("/userlogin/signupuser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value(newUser.getUsername()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value(newUser.getRole()));
    }
    
    /** Test negative scenario - No use found scenario Fail request **/
    @Test
    public void testGetUserDetailsWithNonExistentUsername() throws Exception {
        // Mock the behavior for a non-existent username request
        when(userLoginService.getByUsername("nonexistentuser")).thenReturn(null);

        // Perform the GET request with a non-existent username
        mockMvc.perform(MockMvcRequestBuilders.get("/userlogin/displayuser/{uname}", "nonexistentuser"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string(containsString("No such user in the system.")));
    }



}

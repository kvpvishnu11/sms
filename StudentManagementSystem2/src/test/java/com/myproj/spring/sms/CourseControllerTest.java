package com.myproj.spring.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproj.spring.sms.controllers.CourseController;
import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.service.CourseService;
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

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CourseService courseService;

    @Test
    public void testGetAllCourses() throws Exception {
        List<Course> coursesList = new ArrayList<>();
        
        // Preparing the test data 
        
        coursesList.add(new Course(1L, "Course 1", "3 credits", 20, 1001));
        coursesList.add(new Course(2L, "Course 2", "4 credits", 15, 1002));

        // Mocking the service method call here 
        Mockito.when(courseService.listAllCourses()).thenReturn(coursesList);
        
        //Comparing it 

        mockMvc.perform(MockMvcRequestBuilders.get("/course/getall"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].courseid").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].coursename").value("Course 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].coursecredits").value("3 credits"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].availableseats").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].teacherid").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].courseid").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].coursename").value("Course 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].coursecredits").value("4 credits"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].availableseats").value(15))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].teacherid").value(1002));
    }

    @Test
    public void testSaveCourses() throws Exception {
        List<Course> coursesList = new ArrayList<>();
        // Preparing the test data
        coursesList.add(new Course(1L, "Course 1", "3 credits", 20, 1001));
        coursesList.add(new Course(2L, "Course 2", "4 credits", 15, 1002));

        //Mocking the service method
        Mockito.when(courseService.postAllCourses(Mockito.anyList())).thenReturn(coursesList);
        
        //Comparing the result

        mockMvc.perform(MockMvcRequestBuilders.post("/course/saveall")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(coursesList)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].courseid").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].coursename").value("Course 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].coursecredits").value("3 credits"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].availableseats").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].teacherid").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].courseid").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].coursename").value("Course 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].coursecredits").value("4 credits"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].availableseats").value(15))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].teacherid").value(1002));
    }
}


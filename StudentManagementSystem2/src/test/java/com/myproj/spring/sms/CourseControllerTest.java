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
    
    /** Testing if all the courses can be fetched **/
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
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].course_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].course_name").value("Course 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].course_credits").value("3 credits"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].available_seats").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].teacher_id").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].course_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].course_name").value("Course 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].course_credits").value("4 credits"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].available_seats").value(15))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].teacher_id").value(1002));
    }
    
    /** Testing if all courses can be saved **/

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
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].course_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].course_name").value("Course 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].course_credits").value("3 credits"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].available_seats").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].teacher_id").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].course_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].course_name").value("Course 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].course_credits").value("4 credits"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].available_seats").value(15))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].teacher_id").value(1002));
    }
    /** Testing if saving an empty list of courses **/
    /** Bad request - Fail scenario **/
    @Test
    public void testSaveEmptyCoursesList() throws Exception {
        List<Course> emptyCoursesList = new ArrayList<>();

        mockMvc.perform(MockMvcRequestBuilders.post("/course/saveall")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emptyCoursesList)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Request body is empty."));
    }
}


package com.myproj.spring.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproj.spring.sms.controllers.EnrollmentController;
import com.myproj.spring.sms.dto.BrowseCoursesDTO;
import com.myproj.spring.sms.dto.EnrollmentDTO;
import com.myproj.spring.sms.entities.Course;
import com.myproj.spring.sms.entities.Enrollment;
import com.myproj.spring.sms.service.EnrollmentService;
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

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(EnrollmentController.class)
public class EnrollmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EnrollmentService enrollmentService;
    
    // We are Following 3 steps in every test case here
    // Preparing the test data for my service method 
    // Mocking my service method
    // Comparing the result 

 
    /** Testing if all Enrollments can be saved **/
    @Test
    public void testSaveAllEnrollments() throws Exception {
    	EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
        enrollmentDTO.setStudentId(1);

        // Prepare test data for two courses
        Course course1 = new Course();
        course1.setCourse_id((long) 101);
        course1.setCourse_name("Mathematics");

        Course course2 = new Course();
        course2.setCourse_id((long) 102);
        course2.setCourse_name("History");

        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        enrollmentDTO.setCourseList(courseList);
        
        //Mock the service method call
        
        Mockito.when(enrollmentService.saveEnrollments(Mockito.any(EnrollmentDTO.class)))
                .thenReturn(enrollmentDTO);
        
        //Compare it
        mockMvc.perform(MockMvcRequestBuilders.post("/enrollment/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(enrollmentDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.student_id").value(enrollmentDTO.getStudent_id()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseList[0].course_id").value(course1.getCourse_id()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseList[0].course_name").value(course1.getCourse_name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseList[1].course_id").value(course2.getCourse_id()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseList[1].course_name").value(course2.getCourse_name()));
     } 
    
    /** Testing if all the enrollments can be browsed **/
    @Test
    public void testBrowseEnrollments() throws Exception {
        long studentId = 1;

        List<Enrollment> originalEnrollments = new ArrayList<>();
 
        Mockito.when(enrollmentService.listAllCoursesByStudentID(studentId))
                .thenReturn(originalEnrollments);

        mockMvc.perform(MockMvcRequestBuilders.get("/enrollment/browse/{student_id}", studentId))
                .andExpect(MockMvcResultMatchers.status().isOk());
     }
    
    @Test
    public void testSaveAllEnrollmentsWithEmptyRequestBody() throws Exception {
        EnrollmentDTO emptyEnrollment = new EnrollmentDTO(); // Empty enrollment object

        // Mocking behavior of the service method
        Mockito.when(enrollmentService.saveEnrollments(Mockito.any(EnrollmentDTO.class)))
                .thenReturn(null); // Simulating a failed enrollment saving

        mockMvc.perform(MockMvcRequestBuilders.post("/enrollment/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emptyEnrollment)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Request body is empty.")));
    }

}

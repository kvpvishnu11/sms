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


    @Test
    public void testSaveAllEnrollments() throws Exception {
        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
        enrollmentDTO.setStudentid(1);
        
        // Prepare test data
        Course course1 = new Course();
        // Set properties for course1
        Course course2 = new Course();
        // Set properties for course2
        
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
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentid").value(enrollmentDTO.getStudentid()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseList[0].courseid").value(course1.getCourseid()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseList[0].coursename").value(course1.getCoursename()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseList[1].courseid").value(course2.getCourseid()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseList[1].coursename").value(course2.getCoursename()));
     }

    @Test
    public void testBrowseEnrollments() throws Exception {
        long studentId = 1;

        List<Enrollment> originalEnrollments = new ArrayList<>();
 
        Mockito.when(enrollmentService.listAllCoursesByStudentID(studentId))
                .thenReturn(originalEnrollments);

        mockMvc.perform(MockMvcRequestBuilders.get("/enrollment/browse/{student_id}", studentId))
                .andExpect(MockMvcResultMatchers.status().isOk());
     }
}

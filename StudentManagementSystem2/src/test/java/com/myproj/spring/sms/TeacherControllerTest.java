package com.myproj.spring.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproj.spring.sms.controllers.TeacherController;
import com.myproj.spring.sms.dto.StudentListDTOImpl;
import com.myproj.spring.sms.dto.TeacherListDTOImpl;
import com.myproj.spring.sms.service.TeacherService;
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

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(TeacherController.class)
public class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TeacherService teacherService;
    
    // We are Following 3 steps in every test case here
    // Preparing the test data for my service method 
    // Mocking my service method
    // Comparing the result 

    
    /** Testing if the list of students can be returned **/
    @Test
    public void testDisplayListOfTeachers() throws Exception {
        List<TeacherListDTOImpl> teachers = new ArrayList<>();
 
        Mockito.when(teacherService.listAllTeachers()).thenReturn(teachers);

        mockMvc.perform(MockMvcRequestBuilders.get("/teacher/getall"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(teachers)));
    }
    
    /** Testing fetching list of students for a valid teacher ID **/
    @Test
    public void testDisplayListOfStudentsForValidTeacherID() throws Exception {
        Long validTeacherId = 1L; // A valid teacher ID

        List<StudentListDTOImpl> students = new ArrayList<>(); // Prepare some sample student data
        students.add(new StudentListDTOImpl(2L,"Mike", "Scott"));
        students.add(new StudentListDTOImpl(3L,"Jane", "Smith"));

        when(teacherService.getStudents(validTeacherId)).thenReturn(students);

        mockMvc.perform(MockMvcRequestBuilders.get("/teacher/fetchstudents/{teacherid}", validTeacherId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(students)));
    }
    
    /** Testing fetching list of students for an invalid teacher ID (less than 0) **/
    @Test
    public void testDisplayListOfStudentsForInvalidTeacherID() throws Exception {
        Long invalidTeacherId = -1L; // An invalid teacher ID (less than 0)

        mockMvc.perform(MockMvcRequestBuilders.get("/teacher/fetchstudents/{teacherid}", invalidTeacherId))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Invalid Teacher ID."));
    }


}

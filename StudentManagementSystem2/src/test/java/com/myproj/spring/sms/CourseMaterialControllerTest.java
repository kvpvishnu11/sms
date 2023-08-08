package com.myproj.spring.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproj.spring.sms.controllers.CourseMaterialController;
import com.myproj.spring.sms.entities.CourseMaterial;
import com.myproj.spring.sms.service.CourseMaterialService;
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

@WebMvcTest(CourseMaterialController.class)
public class CourseMaterialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CourseMaterialService courseMaterialService;
    
    // We are Following 3 steps in every test case here
    // Preparing the test data for my service method 
    // Mocking my service method
    // Comparing the result 

    @Test
    public void testSaveNewMaterial() throws Exception {
        CourseMaterial cm = new CourseMaterial(1L, "https://example.com/material1", 1001);

        Mockito.when(courseMaterialService.postNewMaterial(Mockito.any(CourseMaterial.class))).thenReturn(cm);

        mockMvc.perform(MockMvcRequestBuilders.post("/coursematerial/savematerial")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cm)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.coursematerial_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url").value("https://example.com/material1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.course_id").value(1001));
    }

    @Test
    public void testGetMaterial() throws Exception {
        List<CourseMaterial> materialsList = new ArrayList<>();
        materialsList.add(new CourseMaterial(1L, "https://example.com/material1", 1001));
        materialsList.add(new CourseMaterial(2L, "https://example.com/material2", 1001));

        Mockito.when(courseMaterialService.getCourseMaterial(1001L)).thenReturn(materialsList);

        mockMvc.perform(MockMvcRequestBuilders.get("/coursematerial/getcontent/{cid}", 1001))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].coursematerial_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].url").value("https://example.com/material1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].course_id").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].coursematerial_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].url").value("https://example.com/material2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].course_id").value(1001));
    }
}

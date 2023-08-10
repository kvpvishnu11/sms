package com.myproj.spring.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproj.spring.sms.controllers.CourseMaterialController;
import com.myproj.spring.sms.entities.CourseMaterial;
import com.myproj.spring.sms.service.CourseMaterialService;
import org.junit.jupiter.api.Test;
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

@WebMvcTest(CourseMaterialController.class)
public class CourseMaterialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CourseMaterialService courseMaterialService;
    
    /** Testing if all the course material can be saved **/
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
    
    /** Testing if all the course material can be fetched **/

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
    /** Testing fetching course material with a negative course ID **/
    /** Negative scenario - Bad Request **/
    @Test
    public void testGetMaterialWithNegativeCourseID() throws Exception {
        long negativeCourseId = -1L; // Negative course ID

        mockMvc.perform(MockMvcRequestBuilders.get("/coursematerial/getcontent/{cid}", negativeCourseId))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
   
}

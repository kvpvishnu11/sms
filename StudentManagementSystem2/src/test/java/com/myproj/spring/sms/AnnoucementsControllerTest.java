package com.myproj.spring.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproj.spring.sms.controllers.AnnoucementsController;
import com.myproj.spring.sms.entities.Annoucements;
import com.myproj.spring.sms.service.AnnoucementService;
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

@WebMvcTest(AnnoucementsController.class)
public class AnnoucementsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private AnnoucementService annoucementService;

	@Test
	public void testPostAllAnnouncements() throws Exception {

		// Preparing the data for my test case

		List<Annoucements> announcementsList = new ArrayList<>();
		announcementsList.add(new Annoucements(1L, "Announcement 1"));
		announcementsList.add(new Annoucements(2L, "Announcement 2"));

		// Mock the service method

		Mockito.when(annoucementService.postAllAnnouncements(Mockito.anyList())).thenReturn(announcementsList);

		// Compare and test it
		mockMvc.perform(MockMvcRequestBuilders.post("/announcements/saveall").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(announcementsList)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].annoucementid").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].annoucementnote").value("Announcement 1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].annoucementid").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].annoucementnote").value("Announcement 2"));
	}

	@Test
	public void testGetAllAnnouncements() throws Exception {
		// Preparing the data for my test case
		List<Annoucements> announcementsList = new ArrayList<>();
		announcementsList.add(new Annoucements(1L, "Announcement 1"));
		announcementsList.add(new Annoucements(2L, "Announcement 2"));

		// Mock the service method
		Mockito.when(annoucementService.getAllAnnouncements()).thenReturn(announcementsList);

		// Compare and test it
		mockMvc.perform(MockMvcRequestBuilders.get("/announcements/getall"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].annoucementid").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].annoucementnote").value("Announcement 1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].annoucementid").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].annoucementnote").value("Announcement 2"));
	}
}
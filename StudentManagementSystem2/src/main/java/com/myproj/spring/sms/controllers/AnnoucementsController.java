package com.myproj.spring.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.entities.Annoucements;
import com.myproj.spring.sms.service.AnnoucementService;

@RestController
@RequestMapping("/announcements")
public class AnnoucementsController {
	
	@Autowired
	private AnnoucementService annoucementService;
	
	@PostMapping("/saveall")
	public List<Annoucements> postAll(@RequestBody List<Annoucements> a){
		
		return annoucementService.postAllAnnouncements(a);
	}

	@GetMapping("/getall")
	public List<Annoucements> getAllAnnouncements(){
		
		return annoucementService.getAllAnnouncements();
	}
	
}

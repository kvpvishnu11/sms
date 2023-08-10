package com.myproj.spring.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.entities.Annoucements;
import com.myproj.spring.sms.service.AnnoucementService;

/**
 * This controller handles the requests to save the new announcements and get
 * the existing announcements in system
 **/

@RestController
@RequestMapping("/announcements")
public class AnnoucementsController {

	@Autowired
	private AnnoucementService annoucementService;

	/** Saving new Announcements **/
	@PostMapping("/saveall")
	public ResponseEntity<?> postAll(@RequestBody List<Annoucements> a) {
		if (a == null || a.isEmpty()) {
			return ResponseEntity.badRequest().body("Request body is empty.");
		} else {
			List<Annoucements> a1 = annoucementService.postAllAnnouncements(a);
			return ResponseEntity.ok(a1);
		}
	}

	/** Getting all Announcements **/
	@GetMapping("/getall")
	public List<Annoucements> getAllAnnouncements() {

		return annoucementService.getAllAnnouncements();
	}

}

package com.myproj.spring.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.entities.CourseMaterial;
import com.myproj.spring.sms.service.CourseMaterialService;

@RestController
@RequestMapping("/coursematerial")
public class CourseMaterialController {
	
	@Autowired
	private CourseMaterialService courseMaterialService;
	
	@PostMapping("/savematerial")
	public ResponseEntity<?> saveNewMaterial(@RequestBody CourseMaterial cm) {
	    if (cm == null) {
	        return ResponseEntity.badRequest().body("Request body is empty.");
	    } else {
	        CourseMaterial savedMaterial = courseMaterialService.postNewMaterial(cm);
	        return ResponseEntity.ok(savedMaterial);
	    }
	}

	@GetMapping("/getcontent/{cid}")
	public ResponseEntity<?> getMaterial(@PathVariable("cid") Long courseId) {
	    // Check if the courseId is null or invalid
	    if (courseId == null || courseId <= 0) {
	        return ResponseEntity.badRequest().body("Invalid Course ID.");
	    }

	     
	    List<CourseMaterial> courseMaterials = courseMaterialService.getCourseMaterial(courseId);
	    if (courseMaterials == null || courseMaterials.isEmpty()) {
	        return ResponseEntity.badRequest().body("No such Course ID or No content available for that course.");

	    }

	     
	    return ResponseEntity.ok(courseMaterials);
	}

}

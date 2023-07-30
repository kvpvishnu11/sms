package com.myproj.spring.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public CourseMaterial saveNewMaterial(@RequestBody CourseMaterial cm) {
		
		CourseMaterial cm1 = courseMaterialService.postNewMaterial(cm);
		return cm1;
		
	}

	
	@GetMapping("/getcontent/{cid}")
	public List<CourseMaterial> getMaterial(@PathVariable("cid") long courseid) {
		
		return courseMaterialService.getCourseMaterial(courseid);
	}
}

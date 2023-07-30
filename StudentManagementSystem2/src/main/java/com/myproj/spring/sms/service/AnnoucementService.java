package com.myproj.spring.sms.service;

import java.util.List;

import com.myproj.spring.sms.entities.Annoucements;

public interface AnnoucementService {
	
	public List<Annoucements> postAllAnnouncements(List<Annoucements> a); 
	
	public List<Annoucements> getAllAnnouncements();


}

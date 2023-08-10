package com.myproj.spring.sms.service;

/** Announcements Service Interface that contains methods to post new Announcements and get announcements in system **/
 
import java.util.List;

import com.myproj.spring.sms.entities.Annoucements;

public interface AnnoucementService {
	
	public List<Annoucements> postAllAnnouncements(List<Annoucements> a); 
	
	public List<Annoucements> getAllAnnouncements();


}

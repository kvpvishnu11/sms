package com.myproj.spring.sms.service;

/** Implementing the methods that performs business logic and CRUD operations of Announcements Service Interface **/
/** Implements operations to get list of announcements and post all new announcements to DB **/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.entities.Annoucements;
import com.myproj.spring.sms.repositories.AnnoucementsRepository;

import jakarta.transaction.Transactional;

@Component
public class AnnoucementImpl implements AnnoucementService {

	@Autowired
	private AnnoucementsRepository annoucementsRepository;

	/** Save all the new announcements **/
	@Transactional
	@Override
	public List<Annoucements> postAllAnnouncements(List<Annoucements> a) {

		return annoucementsRepository.saveAll(a);
	}

	/** Get all the existing announcements **/
	@Override
	public List<Annoucements> getAllAnnouncements() {

		return annoucementsRepository.findAll();
	}

}

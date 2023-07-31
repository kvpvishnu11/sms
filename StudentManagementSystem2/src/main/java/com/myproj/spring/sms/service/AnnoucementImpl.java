package com.myproj.spring.sms.service;

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
	@Transactional
	@Override
	public List<Annoucements> postAllAnnouncements(List<Annoucements> a) {
		 
		return annoucementsRepository.saveAll(a);
	}
	@Override
	public List<Annoucements> getAllAnnouncements() {
		 
		return annoucementsRepository.findAll();
	}

}

package com.myproj.spring.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproj.spring.sms.entities.Annoucements;

public interface AnnoucementsRepository extends JpaRepository<Annoucements, Long> {

}

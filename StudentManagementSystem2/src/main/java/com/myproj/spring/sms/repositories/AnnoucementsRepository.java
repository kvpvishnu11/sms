package com.myproj.spring.sms.repositories;

/** Repository to handle the CRUD Operations of Announcement Controller **/

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproj.spring.sms.entities.Annoucements;

public interface AnnoucementsRepository extends JpaRepository<Annoucements, Long> {

}

package com.myproj.spring.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproj.spring.sms.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

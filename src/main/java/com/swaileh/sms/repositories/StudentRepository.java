package com.swaileh.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaileh.sms.models.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}

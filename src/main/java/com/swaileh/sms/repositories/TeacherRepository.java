package com.swaileh.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaileh.sms.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}

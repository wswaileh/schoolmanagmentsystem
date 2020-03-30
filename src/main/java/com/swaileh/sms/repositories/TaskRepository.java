package com.swaileh.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaileh.sms.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}

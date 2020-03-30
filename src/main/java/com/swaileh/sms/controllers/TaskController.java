package com.swaileh.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swaileh.sms.models.Task;
import com.swaileh.sms.services.TaskService;

@RestController
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> getTasks(){
		return taskService.getTasks();
	}
	
	@GetMapping("/tasks/{id}")
	public Task getTask(@PathVariable Integer id){
		return taskService.getTask(id);
	}
	
	
	@PostMapping("/tasks")
	public Task addTask(@RequestBody Task task){
		return taskService.addTask(task);
	}
	
	@PutMapping("/tasks/{id}")
	public Task editTask(@PathVariable Integer id,@RequestBody Task updatedTask) {
		return taskService.updateTask(id, updatedTask);
	}
	
	@DeleteMapping("/tasks/{id}")
	public String deleteTask(@PathVariable Integer id) {
		return taskService.deleteTask(id);
	}
	
}

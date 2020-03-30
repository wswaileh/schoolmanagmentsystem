package com.swaileh.sms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swaileh.sms.models.Task;
import com.swaileh.sms.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;

	public List<Task> getTasks() {
		try {
			return taskRepository.findAll();
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	public Task getTask(Integer taskId) {
		try {
			return taskRepository.findById(taskId).get();
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	public Task addTask(Task task) {
		try {
			return taskRepository.save(task);
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	public String deleteTask(Integer taskId) {
		try {
			taskRepository.deleteById(taskId);
			return "Deleted!";
		}
		catch (Exception e) {
			System.err.println(e);
			return "Error occured!";
		}
	}

	public Task updateTask(Integer taskId, Task newTask) {
		try {
			Task oldTask = taskRepository.findById(taskId).get();
			oldTask.copy(newTask);
			return taskRepository.save(oldTask);
		}
		catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
}

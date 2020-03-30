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

import com.swaileh.sms.services.TeacherService;
import com.swaileh.sms.models.Teacher;

@RestController
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/teachers")
	public List<Teacher> getTeachers(){
		return teacherService.getTeachers();
	}
	
	@PostMapping("/teachers")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherService.addTeacher(teacher);
	}
	
	@GetMapping("/teachers/{id}")
	public Teacher getUser(@PathVariable Integer id) {
		return teacherService.getTeacher(id);
	}

	@DeleteMapping("/teachers/{id}")
	public String deleteTeacher(@PathVariable Integer id) {
		return teacherService.deleteTeacher(id);
	}
	
	@PutMapping("/teachers/{id}")
	public Teacher updateTeacher(@RequestBody Teacher newTeacher, @PathVariable Integer id) {
		return teacherService.updateTeacher(id, newTeacher);
	}
}

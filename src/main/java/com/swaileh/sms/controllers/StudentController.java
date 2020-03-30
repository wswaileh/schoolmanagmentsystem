package com.swaileh.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swaileh.sms.services.StudentService;
import com.swaileh.sms.models.Student;

import java.util.List;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable Integer id) {
		return studentService.getStudent(id);
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	

	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		return studentService.deleteStudent(id);
	}
	
	@PutMapping("/students/{id}")
	public Student updateStudent(@RequestBody Student newStudent, @PathVariable Integer id) {
		return studentService.updateStudent(id, newStudent);
	}
	
	
}

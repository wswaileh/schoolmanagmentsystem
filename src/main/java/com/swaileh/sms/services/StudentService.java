package com.swaileh.sms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.swaileh.sms.models.Student;
import com.swaileh.sms.models.Teacher;
import com.swaileh.sms.repositories.StudentRepository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getStudents() {
		try {
			return studentRepository.findAll();
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	public Student getStudent(Integer id) {
		try {
			return studentRepository.findById(id).get();
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	public Student addStudent(Student student) {
		try {
			return studentRepository.save(student);
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	public String deleteStudent(Integer id) {
		try {
			studentRepository.deleteById(id);
			return "Success!";
		} catch (EmptyResultDataAccessException ee) {
			return "No student found with this ID!";
		}
	}

	public Student updateStudent(Integer id, Student newStudent) {
		try {
			Student oldStudent = studentRepository.getOne(id);
			oldStudent.copy(newStudent);
			return studentRepository.save(oldStudent);
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

}

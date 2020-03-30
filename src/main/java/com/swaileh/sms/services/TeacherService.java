package com.swaileh.sms.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.swaileh.sms.models.Teacher;
import com.swaileh.sms.repositories.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;

	public List<Teacher> getTeachers(){
		return teacherRepository.findAll();
	}
	
	public Teacher addTeacher(Teacher teacher) {
		try {
		return teacherRepository.save(teacher);
		}
		catch (Exception e) {
			return new Teacher();
		}
	}
	
	public String deleteTeacher(Integer id) {
		try {
		teacherRepository.deleteById(id);
		return "Success!";
		}
		catch (EmptyResultDataAccessException ee) {
			return "No teacher found with this ID!";
		}
	}
	
	public Teacher updateTeacher(Integer id, Teacher newTeacher) {
		try {
		Teacher oldTeacher = teacherRepository.getOne(id);
		oldTeacher.copy(newTeacher);
		return teacherRepository.save(oldTeacher);
		}
		catch (EntityNotFoundException e) {
			return new Teacher();
		}
		catch(Exception ee) {
			return null;
		}
	}
	
	public Teacher getTeacher(Integer id) {
		try {
			return teacherRepository.findById(id).get();	
		}
		catch (NoSuchElementException e) {
			return null;
		}
		
	}
}

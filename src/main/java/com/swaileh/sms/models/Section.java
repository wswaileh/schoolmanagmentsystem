package com.swaileh.sms.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Section")
public class Section {

	@EmbeddedId
	private SectionIdentity sec_id;
	
	@ManyToMany(cascade= CascadeType.PERSIST, mappedBy = "sections") 
	private List<Teacher> teachers = new ArrayList<Teacher>();

	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "taskSec")
	private List<Task> tasks = new ArrayList<Task>();
	
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "studentSec")
	private List<Student> students = new ArrayList<Student>();



	public Section() {
		
	}
	public Section(SectionIdentity sectionIdentity) {
		this.sec_id = sectionIdentity;
	}
	
	public SectionIdentity getSec_id() {
		return sec_id;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}
	
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public void setSec_id(SectionIdentity sec_id) {
		this.sec_id = sec_id;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	

	@Override
	public String toString() {
		return "To String: Class: " + sec_id.getClass_no() +" Section: " + sec_id.getSec_no() ;
	}
	
	public void copy(Section updatedSection) {
		this.sec_id = updatedSection.getSec_id();
	}

}

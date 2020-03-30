package com.swaileh.sms.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tid_generator")
	@SequenceGenerator(name="tid_generator", sequenceName = "teacher_seq", allocationSize=50)	
	@Column (name="teacher_id")
	private Integer id;
	
	@Column(name="teacher_name", nullable = false)
	private String name;
	
	@JsonBackReference
	@Column(nullable = false)
	private Boolean isAdmin;

	@OneToMany(cascade=CascadeType.PERSIST, mappedBy = "teacherAssignedTask")
	private List<Task> tasks = new ArrayList<Task>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "teacher_section", joinColumns=@JoinColumn(name="teacher_id"),
	inverseJoinColumns = {		
		@JoinColumn(name="class_no"),
		@JoinColumn(name="sec_no"),
	})
	private List<Section> sections = new ArrayList<Section>();
	
	
	public Teacher() {
	}

	public Teacher(Integer id, String name, Boolean isAdmin) {
		this.id = id;
		this.name = name;
		this.isAdmin = isAdmin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Task> getTasks() {
//		return tasks;
//	}
//
//	public void setTasks(List<Task> tasks) {
//		this.tasks = tasks;
//	}

//	public List<Section> getSections() {
//		return sections;
//	}
//
//	public void setSections(List<Section> sections) {
//		this.sections = sections;
//	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public void copy(Teacher updatedTeacher) {
		this.isAdmin = updatedTeacher.getIsAdmin();
		this.name = updatedTeacher.getName();
	}
	

}

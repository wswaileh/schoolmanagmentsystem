package com.swaileh.sms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sid_generator")
	@SequenceGenerator(name="sid_generator", sequenceName = "student_seq", allocationSize=50)
	@Column (name="student_id")
	private Integer id;
	
	@Column(name="student_name", nullable = false)
	private String name;

	@JsonBackReference
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="class_no", referencedColumnName="class_no"),
		@JoinColumn(name="sec_no", referencedColumnName="sec_no")
	})
	private Section studentSec;
	
	public Student() {
	}

	public Student(Integer id, String name, Section studentSec) {
		super();
		this.id = id;
		this.name = name;
		this.studentSec = studentSec;
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


	public Section getStudentSec() {
		return studentSec;
	}

	
	public void setStudentSec(Section studentSec) {
		this.studentSec = studentSec;
	}


	public void copy(Student updatedStudent) {
		this.name = updatedStudent.getName();
//		this.studentSec = updatedStudent.getStudentSec();
	}


	
}

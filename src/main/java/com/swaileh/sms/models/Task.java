package com.swaileh.sms.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskid_generator")
	@SequenceGenerator(name="taskid_generator", sequenceName = "task_seq", allocationSize=50)
	@Column (name="task_id")
	private Integer id;
	
	@Column(name="task_title", nullable = false)
	private String title;
	
	@Column(name="task_details", nullable = false)
	private String details;
	
	@Column(name="due_date", nullable = false)
	private Date dueDate;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="class_no", referencedColumnName="class_no"),
		@JoinColumn(name="sec_no", referencedColumnName="sec_no")
	})
	private Section taskSec;
	
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacherAssignedTask;
	
	public Task() {
		
	}
	public Task(Integer id, String title, String details, Date dueDate, Section taskSec, Teacher teacherAssignedTask) {
		super();
		this.id = id;
		this.title = title;
		this.details = details;
		this.dueDate = dueDate;
		this.taskSec = taskSec;
		this.teacherAssignedTask = teacherAssignedTask;
	}

	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getDetails() {
		return details;
	}




	public void setDetails(String details) {
		this.details = details;
	}




	public Date getDueDate() {
		return dueDate;
	}




	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}




	public Section getTaskSec() {
		return taskSec;
	}




	public void setTaskSec(Section taskSec) {
		this.taskSec = taskSec;
	}




	public Integer getId() {
		return id;
	}




	public Teacher getTeacherAssignedTask() {
		return teacherAssignedTask;
	}




	public void copy(Task updatedTask) {
		this.title = updatedTask.getTitle();
		this.dueDate = updatedTask.getDueDate();
		this.details = updatedTask.getDetails();
	}
	
}

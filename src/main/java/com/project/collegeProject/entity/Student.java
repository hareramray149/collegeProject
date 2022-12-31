package com.project.collegeProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Data
@Entity   
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "st_id")
	Integer student_id;
	
	@Column(name = "st_name")
	String student_name;
	
	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public Integer getStudent_roll() {
		return student_roll;
	}

	public void setStudent_roll(Integer student_roll) {
		this.student_roll = student_roll;
	}

	public Integer getStudent_class() {
		return student_class;
	}

	public void setStudent_class(Integer student_class) {
		this.student_class = student_class;
	}
	
	public Integer getStudent_school_id() {
		return student_school_id;
	}

	public void setStudent_school_id(Integer student_school_id) {
		this.student_school_id = student_school_id;
	}

	@Column(name = "st_roll")
	Integer student_roll;
	
	@Column(name = "st_class")
	Integer student_class;
	
	@Column(name = "st_school_id")
	Integer student_school_id;
	
}

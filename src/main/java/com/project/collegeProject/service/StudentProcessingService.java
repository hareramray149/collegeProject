package com.project.collegeProject.service;


import java.util.List;

import com.project.collegeProject.entity.Student;

public interface StudentProcessingService {
	Student getStudentDetails(Integer student_id) throws Exception;

	List<Student> getStudentDetails() throws Exception;

	Student getStudentDetailsById(Integer student_id) throws Exception;

	Student getStudentDetail(Student student) throws Exception;

	Student updateStudentDetail(Student student);

	void deleteStudentDetail(Integer student_id);
}

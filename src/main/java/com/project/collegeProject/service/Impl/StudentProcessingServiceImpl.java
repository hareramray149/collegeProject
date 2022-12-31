package com.project.collegeProject.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.collegeProject.entity.Student;
import com.project.collegeProject.repository.StudentRepository;
import com.project.collegeProject.service.StudentProcessingService;

@Service
public class StudentProcessingServiceImpl implements StudentProcessingService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student getStudentDetails(Integer student_id) throws Exception{
		// TODO Auto-generated method stub
		try {
			
			return studentRepository.getStudentData(student_id);
			
		} catch (Exception e) {
			
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public
	List<Student> getStudentDetails() throws Exception {
		
		return studentRepository.findAll();
	}
	
	@Override
	public
	Student getStudentDetailsById(Integer student_id) throws Exception {
		
		 Student st = studentRepository.getStudentData(student_id);
		 return st;
	}
	
	@Override
	public Student getStudentDetail(Student student) throws Exception {
		
		return studentRepository.save(student);
		
	}
	
	@Override
	public Student updateStudentDetail(Student student) {
		Student st = studentRepository.findById(student.getStudent_id()).orElse(null);
		
		st.setStudent_name(student.getStudent_name());
		st.setStudent_roll(student.getStudent_roll());
		st.setStudent_class(student.getStudent_class());
		
		return studentRepository.save(st);
	}
	
	@Override
	public void deleteStudentDetail(Integer student_id) {
		studentRepository.deleteById(student_id);
	}

}

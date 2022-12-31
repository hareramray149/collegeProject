package com.project.collegeProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.collegeProject.entity.Student;
import com.project.collegeProject.model.StudentWithSchoolDetails;
import com.project.collegeProject.repository.StudentRepository;
import com.project.collegeProject.security.CheckAuth;
import com.project.collegeProject.service.StudentProcessingService;

import reactor.netty.http.server.HttpServerRequest;

@RestController
public class StudentDetailsController {
	
	@Autowired
	public StudentProcessingService studentProcessing;
	
	@Autowired
	public StudentRepository studentRepository;
	
	@Autowired
	private CheckAuth checkAuth;

	@GetMapping("/getStudentDetails")
	public List<Student> getStudentDetails(HttpServletRequest request) throws Exception {
		if(checkAuth.checkAuth(request)) {
		  return studentProcessing.getStudentDetails();
		}
		return null;
	}
	
	@PostMapping("/getStudentDetailsById") 
	public Student getStudentDetailsById(@RequestBody Integer student_id, HttpServletRequest request) throws Exception {
		
		if(checkAuth.checkAuth(request)) {
			return studentProcessing.getStudentDetailsById(student_id);
		}
			return null;
		 
	}
	
	@PostMapping("/setStudentDetail")
	public Student getStudentDetail(@RequestBody Student student, HttpServletRequest request) throws Exception {
		if(checkAuth.checkAuth(request)) {
			return studentProcessing.getStudentDetail(student);
		}
		return null;
		
	}
	
	@PostMapping("/updateStudentDetail")
	public Student updateStudentDetail(@RequestBody Student student, HttpServletRequest request) throws Exception {
		
		if(checkAuth.checkAuth(request)) {
		return studentProcessing.updateStudentDetail(student);
		}
		return null;
		
	}
	
	@PostMapping("/deleteStudentDetail")
	public String deleteStudentDetail(@RequestBody Integer student_id, HttpServletRequest request) {
		
		if(checkAuth.checkAuth(request)) {
			studentProcessing.deleteStudentDetail(student_id);
			
			return "Deleted Student id : " + student_id; 
		}
		return null;
	}
	
	@PostMapping("/getStudentDetailWithSchool")
	public Object getStudentDetailWithSchool(@RequestBody Integer student_id, HttpServletRequest request) {
		
		if(checkAuth.checkAuth(request)) {
			StudentWithSchoolDetails studentWithSchoolDetails ;
			List<StudentWithSchoolDetails> studentWithSchoolDetailsList = new ArrayList<StudentWithSchoolDetails>();
					
			List<Object[]> ob = studentRepository.getStudentAndSchoolData();
			
			for( Object[] objItr : ob) {
				studentWithSchoolDetails = new StudentWithSchoolDetails();
		
				studentWithSchoolDetails.setStudent_name((String)objItr[0]);
				studentWithSchoolDetails.setStudent_roll((Integer)objItr[1]);
				studentWithSchoolDetails.setStudent_class((Integer)objItr[2]);
				studentWithSchoolDetails.setSchool_name((String)objItr[3]);
				
				studentWithSchoolDetailsList.add(studentWithSchoolDetails);
			}
			
			return studentWithSchoolDetailsList; 
		}
		return null;
	}
}

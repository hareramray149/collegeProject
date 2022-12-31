package com.project.collegeProject.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.collegeProject.entity.School;
import com.project.collegeProject.repository.SchoolRepository;
import com.project.collegeProject.security.CheckAuth;
import com.project.collegeProject.service.StudentProcessingService;

@RestController
public class CollegeDetailController {
	
	@Autowired
	public StudentProcessingService studentProcessing;
	
	@Autowired
	public SchoolRepository schoolRepository;
	
	@Autowired
	private CheckAuth checkAuth;
	
	@PostMapping("/setSchoolDetail")
	public School setSchoolDetails(@RequestBody School school, HttpServletRequest request){
		if(checkAuth.checkAuth(request)) {
			return schoolRepository.save(school);
		}
		return null;
		
	}
	
	@PostMapping("/getSchoolDetailById")
	public School getSchoolDetailsById(@RequestBody Integer school_id, HttpServletRequest request){
		if(checkAuth.checkAuth(request)) {
		return schoolRepository.findById(school_id).get();
		}
		return null;
		
	}
	
	@GetMapping("/getSchoolsDetail")
	public List<School> getSchoolDetails(HttpServletRequest request){
		if(checkAuth.checkAuth(request)) {
			return schoolRepository.findAll();
		}
		return null;
	}
	
}

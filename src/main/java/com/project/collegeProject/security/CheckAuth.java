package com.project.collegeProject.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CheckAuth {
	
	private static String code;

    @Value("${VAR}")
    public void setSvnUrl(String code) {
        this.code = code;
    }
	
	public Boolean checkAuth(HttpServletRequest request) {
		if(!request.getHeader("Authorization").isBlank() && !request.getHeader("Authorization").isEmpty() && request.getHeader("Authorization").equals(code)) {
			return true;
		}
		return false;
	}


}

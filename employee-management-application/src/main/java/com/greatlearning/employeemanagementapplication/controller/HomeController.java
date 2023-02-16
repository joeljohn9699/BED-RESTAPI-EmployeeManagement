package com.greatlearning.employeemanagementapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "greatlearning";
	}

	@RequestMapping("/403")
	public ResponseEntity<String> accessDeniedPage() {
		return new ResponseEntity<String>("You don't have access to this page.", HttpStatus.UNAUTHORIZED);

	}

}

package com.greatlearning.employeemanagementapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagementapplication.entity.User;
import com.greatlearning.employeemanagementapplication.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);

	}

	@GetMapping("/listUsers")
	public List<User> listUsers() {
		return userService.listUsers();

	}

	@DeleteMapping("/deleteUser/{user_id}")
	public String deleteUser(@PathVariable("user_id") int user_id) {
		userService.deleteUser(user_id);
		return "Deleted User by id - " + user_id;
	}

}

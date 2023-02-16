package com.greatlearning.employeemanagementapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagementapplication.entity.Role;
import com.greatlearning.employeemanagementapplication.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping("/saveRole")
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {
		return new ResponseEntity<Role>(roleService.saveRole(role), HttpStatus.CREATED);

	}

	@GetMapping("/listRoles")
	public List<Role> listRoles() {
		return roleService.listRoles();

	}

}

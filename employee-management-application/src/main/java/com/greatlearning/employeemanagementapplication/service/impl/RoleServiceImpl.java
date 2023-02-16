package com.greatlearning.employeemanagementapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementapplication.entity.Role;
import com.greatlearning.employeemanagementapplication.repository.RoleRepository;
import com.greatlearning.employeemanagementapplication.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> listRoles() {
		return roleRepository.findAll();
	}

}

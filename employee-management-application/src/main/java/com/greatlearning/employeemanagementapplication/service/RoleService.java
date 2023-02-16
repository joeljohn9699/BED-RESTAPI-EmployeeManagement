package com.greatlearning.employeemanagementapplication.service;

import java.util.List;

import com.greatlearning.employeemanagementapplication.entity.Role;

public interface RoleService {

	Role saveRole(Role role);

	List<Role> listRoles();

}

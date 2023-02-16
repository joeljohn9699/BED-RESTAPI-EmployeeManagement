package com.greatlearning.employeemanagementapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagementapplication.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}

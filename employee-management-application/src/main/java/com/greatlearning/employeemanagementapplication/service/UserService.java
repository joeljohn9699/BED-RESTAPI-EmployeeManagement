package com.greatlearning.employeemanagementapplication.service;

import java.util.List;

import com.greatlearning.employeemanagementapplication.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> listUsers();

	void deleteUser(int user_id);

}

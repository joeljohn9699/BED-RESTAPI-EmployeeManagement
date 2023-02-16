package com.greatlearning.employeemanagementapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementapplication.entity.User;
import com.greatlearning.employeemanagementapplication.repository.UserRepository;
import com.greatlearning.employeemanagementapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public List<User> listUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(int user_id) {
		userRepository.deleteById(user_id);
	}

}

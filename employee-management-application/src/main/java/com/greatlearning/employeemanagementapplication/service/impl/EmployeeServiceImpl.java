package com.greatlearning.employeemanagementapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementapplication.entity.Employee;
import com.greatlearning.employeemanagementapplication.repository.EmployeeRepository;
import com.greatlearning.employeemanagementapplication.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		Employee existingEmployee = employeeRepository.findById(id).get();
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> searchEmployeesByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	@Override
	public List<Employee> sortEmployeesByFirstName(String order) {
		return employeeRepository.findAll(Sort.by(Sort.Direction.fromString(order), "firstName"));
	}

}

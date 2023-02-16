package com.greatlearning.employeemanagementapplication.service;

import java.util.List;

import com.greatlearning.employeemanagementapplication.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> listEmployees();

	Employee getEmployeeById(int id);

	Employee updateEmployee(Employee employee, int id);

	void deleteEmployee(int id);

	List<Employee> searchEmployeesByFirstName(String firstName);

	List<Employee> sortEmployeesByFirstName(String order);

}

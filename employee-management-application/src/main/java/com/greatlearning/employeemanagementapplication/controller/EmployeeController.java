package com.greatlearning.employeemanagementapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagementapplication.entity.Employee;
import com.greatlearning.employeemanagementapplication.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);

	}

	@GetMapping("/listEmployees")
	public List<Employee> listEmployees() {
		return employeeService.listEmployees();

	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);

	}

	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(employee, id);

	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return "Deleted Employee by id - " + id;
	}

	@GetMapping("/searchEmployees/{firstName}")
	public List<Employee> searchEmployees(@PathVariable("firstName") String firstName) {
		return employeeService.searchEmployeesByFirstName(firstName);

	}

	@GetMapping("/sortEmployees")
	public List<Employee> sortEmployees(String order) {
		return employeeService.sortEmployeesByFirstName(order);

	}

}

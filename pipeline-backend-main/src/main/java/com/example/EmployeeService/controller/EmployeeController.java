package com.example.EmployeeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeService.model.Employee;
import com.example.EmployeeService.service.EmployeeService;

@CrossOrigin(methods = {RequestMethod.GET,RequestMethod.POST})
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/list")
	public List<Employee> getEmployees() {
		return service.getAllEmployees();
	}
	
	@PostMapping("/emloyee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		Employee e = service.saveEmployee(emp);
		return ResponseEntity.ok(e);
	}
	

}

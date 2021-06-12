package com.example.EmployeeService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeService.entity.EmployeeEntity;
import com.example.EmployeeService.model.Employee;
import com.example.EmployeeService.repository.EmployeeReporsitory;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeReporsitory repository;
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> employees = new ArrayList<Employee>();
		
		repository.findAll().forEach(item->{
			Employee e = new Employee();
			e.setId(item.getId());
			e.setName(item.getName());
			e.setDept(item.getDept());
			
			employees.add(e);
		});
		
		return employees;
	}
	
	public Employee saveEmployee(Employee emp)
	{
		EmployeeEntity en = new EmployeeEntity();
		
		en.setId(emp.getId());
		en.setName(emp.getName());
		en.setDept(emp.getDept());
		
		repository.save(en);
		
		return emp;
	}

}

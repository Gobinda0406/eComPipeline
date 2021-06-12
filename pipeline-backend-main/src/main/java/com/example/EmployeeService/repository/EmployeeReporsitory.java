package com.example.EmployeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeService.entity.EmployeeEntity;

public interface EmployeeReporsitory extends JpaRepository<EmployeeEntity,String> {

	

}

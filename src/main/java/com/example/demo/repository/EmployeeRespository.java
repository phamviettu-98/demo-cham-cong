package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.enity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
	
	

}

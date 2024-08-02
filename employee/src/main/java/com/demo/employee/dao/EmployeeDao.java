package com.demo.employee.dao;

import java.util.Optional;

import com.demo.employee.entity.Employee;

public interface EmployeeDao {

	void saveEmployeeDetails(Employee employee);
	
	Optional<Employee>  findById(String id);

}

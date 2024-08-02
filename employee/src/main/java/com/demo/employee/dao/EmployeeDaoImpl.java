package com.demo.employee.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.employee.entity.Employee;
import com.demo.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveEmployeeDetails(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> findById(String id) {
		return employeeRepository.findById(id);
	}

}

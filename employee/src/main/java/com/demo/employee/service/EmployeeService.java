package com.demo.employee.service;

import com.demo.employee.dto.EmployeeDto;
import com.demo.employee.response.EmployeeResponse;

import jakarta.validation.Valid;

public interface EmployeeService {

	void saveEmployeeDetails(@Valid EmployeeDto employeeDto);

	EmployeeResponse getEmployeeTaxDeductions(String id);

}

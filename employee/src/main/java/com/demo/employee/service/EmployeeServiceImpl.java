package com.demo.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.demo.employee.dao.EmployeeDao;
import com.demo.employee.dto.EmployeeDto;
import com.demo.employee.entity.Employee;
import com.demo.employee.exception.ServiceException;
import com.demo.employee.response.EmployeeResponse;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void saveEmployeeDetails(@Valid EmployeeDto employeeDto) {
		Employee employee = maptoEntity(employeeDto);
		employeeDao.saveEmployeeDetails(employee);
	}

	@Override
	public EmployeeResponse getEmployeeTaxDeductions(String id) {
		Optional<Employee> employee = employeeDao.findById(id);
		if(employee.isEmpty()) {
			throw new ServiceException(HttpStatusCode.valueOf(404), "Employee with id "+id+" not found");
		}
		Employee emp = employee.get();
		double tax = calculateTax(emp.getSalary());
		double cess = calculateCess(emp.getSalary());
		return EmployeeResponse.builder().employeeId(emp.getEmployeeId()).firstName(emp.getFirstName()).lastName(emp.getLastName()).taxAmount(tax).cessAmount(cess).build();
	}
	
	private double calculateCess(double salary) {
		double cess = 0.0;
		if(salary>2500000) {
			cess = 0.02*(salary-2500000);
		}
		return cess;
	}

	private double calculateTax(double salary) {
		
		double tax = 0.0;

        if (salary <= 250000) {
            tax = 0.0;
        } else if (salary <= 500000) {
            tax += (salary - 250000) * 0.05;
        } else if (salary <= 1000000) {
            tax += (500000 - 250000) * 0.05;
            tax += (salary - 500000) * 0.1;
        } else {
            tax += (500000 - 250000) * 0.05;
            tax += (1000000 - 500000) * 0.1;
            tax += (salary - 1000000) * 0.2;
        }
        
        return tax;
		
	}

	private static Employee maptoEntity(EmployeeDto employeeDto){
		Employee emp = new Employee();
		emp.setEmployeeId(employeeDto.getEmployeeId());
		emp.setFirstName(employeeDto.getFirstName());
		emp.setLastName(employeeDto.getLastName());
		emp.setEmail(employeeDto.getEmail());
		emp.setPhoneNumbers(employeeDto.getPhoneNumbers());
		emp.setDoj(employeeDto.getDoj());
		emp.setSalary(employeeDto.getSalary());
		return emp;
	}

}

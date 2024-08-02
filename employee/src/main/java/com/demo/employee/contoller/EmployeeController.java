package com.demo.employee.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.dto.EmployeeDto;
import com.demo.employee.response.EmployeeResponse;
import com.demo.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(consumes="application/json",produces="application/json")
	public ResponseEntity<String> storeEmployeeDetails(@Valid @RequestBody EmployeeDto employeeDto){
		employeeService.saveEmployeeDetails(employeeDto);
		return new ResponseEntity<String>("Details stored successfully.",HttpStatus.CREATED);
	}
	
	@GetMapping(value="{employeeId}/tax-deductions",produces="application/json")
	public ResponseEntity<EmployeeResponse> returnTaxDeductions(@PathVariable("employeeId")String id ){
		EmployeeResponse response = employeeService.getEmployeeTaxDeductions(id);
		return new ResponseEntity<EmployeeResponse>(response,HttpStatus.OK);
	}

}

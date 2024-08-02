package com.demo.employee.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
	
	@Id
	private String employeeId;         //(String): Unique identifier for the employee.
	
	@Column(name="first_name")
	private String firstName;          // (String): First name of the employee.
	
	@Column(name="last_name")
	private String lastName ;          //(String): Last name of the employee.
	
	@Column(name="email")
	private String email;              // (String): Email address of the employee.
	
	@Column(name="phone_numbers")
	private List<String> phoneNumbers; // (List<String>): List of phone numbers for the employee.
	
	@Column(name="doj")
	private String doj;                 // (String): Date of joining in YYYY-MM-DD format.
	
	@Column(name="salary")
	private double salary;              // (Double): Monthly salary of the employee.

}

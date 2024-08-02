package com.demo.employee.dto;

import java.util.List;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

private String employeeId;         
	
	
@NotBlank(message = "First name is required")
@Size(min = 2, max = 25, message = "First name must be between 2 and 25 characters long")
private String firstName;

@NotBlank(message = "Last name is required")
@Size(min = 2, max = 25, message = "Last name must be between 2 and 25 characters long")
private String lastName;

@NotBlank(message = "Email is required")
@Email(message = "Email should be valid")
private String email;

@NotEmpty(message = "At least one phone number is required")
private List<
        @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number") 
        String> phoneNumbers;

@NotBlank(message = "Date of joining is required")
@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of joining must be in the format yyyy-MM-dd")
private String doj;

@DecimalMin(value = "0.0", inclusive = true, message = "Salary must be greater than or equal to 0.0")
private double salary;
	
}

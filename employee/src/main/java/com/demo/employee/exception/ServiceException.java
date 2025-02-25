package com.demo.employee.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;
import lombok.Setter;

public class ServiceException extends ResponseStatusException {

	private static final long serialVersionUID = -3438120294345638176L;
	
	@Getter
	@Setter
	private HttpStatusCode httpStatusCode;
	
	@Getter
	@Setter
	private String message;
	
	public ServiceException(HttpStatusCode httpStatusCode, String message) {
		super(httpStatusCode, message);
		this.httpStatusCode = httpStatusCode;
		this.message = message;
	}
}

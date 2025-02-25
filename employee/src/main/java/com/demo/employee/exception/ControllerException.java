  package com.demo.employee.exception;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorResponse> handleServiceException(ServiceException cause, WebRequest webRequest) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), cause.getMessage());
		return new ResponseEntity<ErrorResponse>(error, cause.getHttpStatusCode());
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse>handleBadRequestException(BadRequestException cause,WebRequest webRequest){
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), cause.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllException(Exception cause, WebRequest webRequest) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), cause.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}

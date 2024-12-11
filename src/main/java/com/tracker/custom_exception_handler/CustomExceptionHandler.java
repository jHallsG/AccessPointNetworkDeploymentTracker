package com.tracker.custom_exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tracker.custom_response_handler.ResponseHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(value = {CustomSQLIntegrityConstraintViolationException.class})
	public ResponseEntity<Object> handleSqlConstraintsException(CustomSQLIntegrityConstraintViolationException exceptionError){
		
		HttpStatus status;
		
		if (exceptionError.getMessage().contains("cannot be null")) {
	        status = HttpStatus.BAD_REQUEST;
	    } else if (exceptionError.getMessage().contains("Duplicate entry") || exceptionError.getMessage().contains("already exists")) {
	        status = HttpStatus.CONFLICT;
	    } else {
	        status = HttpStatus.INTERNAL_SERVER_ERROR;
	    }
		
		return ResponseHandler.responseBuilder(status, exceptionError.getMessage());
	}
	
	@ExceptionHandler(value = {CustomNoSuchElementException.class, CustomEntityNotFoundException.class})
	public ResponseEntity<Object> handleNotFoundException(RuntimeException exceptionError){
		
		return ResponseHandler.responseBuilder(HttpStatus.NOT_FOUND, exceptionError.getMessage());
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> generalExceptionHandler(Exception exception){
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		return ResponseHandler.exceptionResponseBuilder(
				HttpStatus.INTERNAL_SERVER_ERROR, 
				exception.getClass().getName(),
				exception.getMessage(),
				request.getRequestURI());
	}
}

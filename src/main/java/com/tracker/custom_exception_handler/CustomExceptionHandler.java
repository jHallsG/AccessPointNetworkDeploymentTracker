package com.tracker.custom_exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tracker.custom_response_handler.ResponseHandler;

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
	
	@ExceptionHandler(value = {CustomNoSuchElementException.class})
	public ResponseEntity<Object> handleSqlConstraintsException(CustomNoSuchElementException exceptionError){
		
		return ResponseHandler.responseBuilder(HttpStatus.NOT_FOUND, exceptionError.getMessage());
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> generalExceptionHandler(Exception exception){
		
		return ResponseHandler.responseBuilder(
				HttpStatus.INTERNAL_SERVER_ERROR, 
				exception.getClass().getName() + ":" + exception.getMessage());
		
	}
}
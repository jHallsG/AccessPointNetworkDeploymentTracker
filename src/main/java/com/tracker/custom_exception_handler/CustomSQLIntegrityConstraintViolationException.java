package com.tracker.custom_exception_handler;

import java.sql.SQLIntegrityConstraintViolationException;

public class CustomSQLIntegrityConstraintViolationException extends SQLIntegrityConstraintViolationException{
	
	public CustomSQLIntegrityConstraintViolationException(String message) {
		super(message);
	}
}

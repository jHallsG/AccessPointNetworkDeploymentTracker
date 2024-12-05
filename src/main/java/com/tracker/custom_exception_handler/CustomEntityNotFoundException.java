package com.tracker.custom_exception_handler;

import jakarta.persistence.EntityNotFoundException;

public class CustomEntityNotFoundException extends EntityNotFoundException{
	
	public CustomEntityNotFoundException(String message) {
		super(message);
	}

}

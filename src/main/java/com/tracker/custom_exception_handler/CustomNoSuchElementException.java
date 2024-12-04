package com.tracker.custom_exception_handler;

import java.util.NoSuchElementException;

public class CustomNoSuchElementException extends NoSuchElementException{
	
	public CustomNoSuchElementException(String message) {
		super(message);
	}

}

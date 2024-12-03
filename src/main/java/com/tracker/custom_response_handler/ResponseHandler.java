package com.tracker.custom_response_handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	
	public static ResponseEntity<Object> responseBuilder(HttpStatus status, String message, Object responseObject){
		Map<String, Object> response = new HashMap<>();
		
		response.put("status", status);
		response.put("message", message);
		response.put("data", responseObject);
		response.put("timestamp", LocalDateTime.now());
		
		return new ResponseEntity<>(response, status);
	}
	
	public static ResponseEntity<Object> responseBuilder(HttpStatus status, String message){
		Map<String, Object> response = new HashMap<>();
		
		response.put("status", status);
		response.put("message", message);
		response.put("timestamp", LocalDateTime.now());
		
		return new ResponseEntity<>(response, status);
	}

}

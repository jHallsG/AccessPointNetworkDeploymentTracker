package com.tracker.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.custom_exception_handler.CustomSQLIntegrityConstraintViolationException;
import com.tracker.custom_response_handler.ResponseHandler;
import com.tracker.entities.UserEntity;
import com.tracker.services.UserServices;

@RestController
public class UserController {
	
	private UserServices userService;
	
	public UserController(UserServices userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody UserEntity user) throws CustomSQLIntegrityConstraintViolationException {
		return ResponseHandler.responseBuilder(HttpStatus.OK, user.getUsername() + " successfully registered.", userService.register(user));
	}
}

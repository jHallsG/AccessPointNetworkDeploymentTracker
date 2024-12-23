package com.tracker.services.impl;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tracker.custom_exception_handler.CustomSQLIntegrityConstraintViolationException;
import com.tracker.entities.UserEntity;
import com.tracker.repositories.UserRepo;
import com.tracker.services.UserServices;

@Service
public class UserServiceImpl implements UserServices{
	
	private UserRepo userRepo;
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	public UserEntity register(UserEntity user) throws CustomSQLIntegrityConstraintViolationException {
		
		Optional<UserEntity> optionalUser = userRepo.findByUsernameOrEngrId(user.getUsername(), user.getEngrId());
		
		if (optionalUser.isPresent()) {
			if (optionalUser.get().getUsername().equals(user.getUsername())) {
				throw new CustomSQLIntegrityConstraintViolationException("Username already exists.");
			} else {
				throw new CustomSQLIntegrityConstraintViolationException("Engineer ID already registered.");
			}
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		if (user.getRole() == null) user.setRole("ENGINEER");
		
		return userRepo.save(user);
	}
}

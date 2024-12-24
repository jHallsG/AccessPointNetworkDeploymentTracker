package com.tracker.services.impl;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
	private AuthenticationManager authManager;
	private JWTService jwt;
	
	public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, AuthenticationManager authManager, JWTService jwt) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.authManager = authManager;
		this.jwt = jwt;
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
	
	public String verify(UserEntity user) {
		// verify/authenticate user
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		// generate token
		return (auth.isAuthenticated()) ? jwt.generateToken(user.getUsername()) : "Username and password does not exist.";
	}
}

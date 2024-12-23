package com.tracker.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tracker.entities.UserEntity;
import com.tracker.repositories.UserRepo;
import com.tracker.security.auth.UserPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private UserRepo userRepo;
	
	public UserDetailsServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByUsername(username);
		
		if (user == null) throw new UsernameNotFoundException("Username not found. Register first.");
		
		return new UserPrincipal(user);
	}
}

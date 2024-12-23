package com.tracker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	Optional<UserEntity> findByUsernameOrEngrId(String username, String engrId);
	UserEntity findByUsername(String username);
}

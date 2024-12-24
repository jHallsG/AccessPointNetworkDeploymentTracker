package com.tracker.services;

import com.tracker.custom_exception_handler.CustomSQLIntegrityConstraintViolationException;
import com.tracker.entities.UserEntity;

public interface UserServices {
	
	UserEntity register(UserEntity user) throws CustomSQLIntegrityConstraintViolationException;
	String verify(UserEntity user);

}

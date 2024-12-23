package com.tracker.services;

import com.tracker.custom_exception_handler.CustomSQLIntegrityConstraintViolationException;
import com.tracker.entities.UserEntity;

public interface UserServices {
	
	public UserEntity register(UserEntity user) throws CustomSQLIntegrityConstraintViolationException;

}

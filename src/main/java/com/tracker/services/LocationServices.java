package com.tracker.services;

import java.util.List;

import com.tracker.custom_exception_handler.CustomSQLIntegrityConstraintViolationException;
import com.tracker.entities.LocationEntity;

public interface LocationServices {

	List<LocationEntity> viewAllLocations();
	LocationEntity addNewLocation(LocationEntity location) throws CustomSQLIntegrityConstraintViolationException;
	LocationEntity updateLocationDetails(LocationEntity location) throws CustomSQLIntegrityConstraintViolationException;
	String deleteLocation(int locId);
	List<LocationEntity> searchLocationByName(String locName);
	
}

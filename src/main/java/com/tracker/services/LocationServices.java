package com.tracker.services;

import java.util.List;

import com.tracker.entities.LocationEntity;

public interface LocationServices {

	List<LocationEntity> viewAllLocations();
	LocationEntity addNewLocation(LocationEntity location);
	LocationEntity updateLocationDetails(String locId);
	LocationEntity deleteLocation(String locId);
	LocationEntity searchlocationByIdName(String locId, String locName);
	
}

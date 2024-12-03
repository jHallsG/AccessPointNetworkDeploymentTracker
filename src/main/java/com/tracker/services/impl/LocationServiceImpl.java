package com.tracker.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tracker.entities.LocationEntity;
import com.tracker.repositories.LocationRepository;
import com.tracker.services.LocationServices;

@Service
public class LocationServiceImpl implements LocationServices{
	
	private LocationRepository locationRepository;
	
	public LocationServiceImpl(LocationRepository locationRepository){
		this.locationRepository = locationRepository;
	}

	@Override
	public List<LocationEntity> viewAllLocations() {
		
		return locationRepository.findAll();
	}

	@Override
	public LocationEntity addNewLocation(LocationEntity location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationEntity updateLocationDetails(String locId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationEntity deleteLocation(String locId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationEntity searchlocationByIdName(String locId, String locName) {
		// TODO Auto-generated method stub
		return null;
	}

}

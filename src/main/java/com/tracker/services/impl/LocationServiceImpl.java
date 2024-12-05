package com.tracker.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tracker.custom_exception_handler.CustomNoSuchElementException;
import com.tracker.custom_exception_handler.CustomSQLIntegrityConstraintViolationException;
import com.tracker.entities.LocationEntity;
import com.tracker.repositories.LocationRepository;
import com.tracker.services.LocationServices;

import jakarta.transaction.Transactional;

@Service
public class LocationServiceImpl implements LocationServices {

	private LocationRepository locationRepository;

	public LocationServiceImpl(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public List<LocationEntity> viewAllLocations() {

		return locationRepository.findAll();
	}

	@Override
	@Transactional
	public LocationEntity addNewLocation(LocationEntity location)
			throws CustomSQLIntegrityConstraintViolationException {

		Optional<LocationEntity> optionalLocationRecord = locationRepository.findByLocName(location.getLocName());

		if (optionalLocationRecord.isPresent())
			throw new CustomSQLIntegrityConstraintViolationException("Location name already exists.");

		return locationRepository.save(location);
	}

	@Override
	@Transactional
	public LocationEntity updateLocationDetails(LocationEntity location) throws CustomSQLIntegrityConstraintViolationException {
		
		if (location.getLocId() == 0) throw new IllegalArgumentException("Location ID must be specified"); 

		Optional<LocationEntity> optionalLocationRecord = locationRepository.findByLocName(location.getLocName());

		if (optionalLocationRecord.isPresent())
			throw new CustomSQLIntegrityConstraintViolationException("Location name already exists.");

		return locationRepository.save(location);
	}

	@Override
	@Transactional
	public String deleteLocation(int locId) {
		
		Optional<LocationEntity> optionalLocationRecord = locationRepository.findById(locId);
		
		if (optionalLocationRecord.isPresent()) {
			locationRepository.deleteById(locId);
			return "Location ID : " + locId + " successfully deleted";
		} else throw new CustomNoSuchElementException("Location does not exist.");
		
	}

	@Override
	public List<LocationEntity> searchLocationByName(String locName) {
		
		return locationRepository.findByLocNameContaining(locName);
	}

}

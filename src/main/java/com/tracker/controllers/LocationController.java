package com.tracker.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.custom_exception_handler.CustomSQLIntegrityConstraintViolationException;
import com.tracker.custom_response_handler.ResponseHandler;
import com.tracker.entities.LocationEntity;
import com.tracker.services.LocationServices;

@RestController
@RequestMapping("/locations")
public class LocationController {
	
	private LocationServices locationService;
	
	public LocationController(LocationServices locationService){
		this.locationService = locationService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addNewLocation(@RequestBody LocationEntity location) throws CustomSQLIntegrityConstraintViolationException {
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Location successfully added", locationService.addNewLocation(location));
	}
	
	@GetMapping("/view-all")
	public ResponseEntity<Object> viewAll(){
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "All location entries successfully retrieved", locationService.viewAllLocations());
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateLocationInfo(@RequestBody LocationEntity location) throws CustomSQLIntegrityConstraintViolationException {
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Location successfully updated", locationService.updateLocationDetails(location));
	}
	
	@DeleteMapping("/delete/{locId}")
	public ResponseEntity<Object> deleteLocation(@PathVariable("locId") int locId ) {
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Delete Successful", locationService.deleteLocation(locId));
	}
	
	@GetMapping("/search")
	public ResponseEntity<Object> search(@RequestParam("search") String search){
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Search successful", locationService.searchLocationByName(search));
	}

}

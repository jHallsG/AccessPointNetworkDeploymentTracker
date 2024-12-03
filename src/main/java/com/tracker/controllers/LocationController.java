package com.tracker.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<Object> addNewLocation(LocationEntity location) {
		return ResponseHandler.responseBuilder(HttpStatus.OK, "All location entries successfully retrieved", locationService.addNewLocation(location));
	}
	
	@GetMapping("/view-all")
	public ResponseEntity<Object> viewAll(){
		return ResponseHandler.responseBuilder(HttpStatus.OK, "All location entries successfully retrieved", locationService.viewAllLocations());
	}

}

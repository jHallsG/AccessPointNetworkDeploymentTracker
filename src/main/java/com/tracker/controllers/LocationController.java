package com.tracker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.entities.LocationEntity;
import com.tracker.services.LocationServices;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	private LocationServices locationService;
	
	LocationController(LocationServices locationService){
		this.locationService = locationService;
	}
	
	@PostMapping("/add")
	public LocationEntity addNewLocation(LocationEntity location) {
		return locationService.addNewLocation(location);
	}

}

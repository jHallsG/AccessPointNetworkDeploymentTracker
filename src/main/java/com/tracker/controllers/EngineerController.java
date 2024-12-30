package com.tracker.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.custom_response_handler.ResponseHandler;
import com.tracker.entities.EngineerEntity;
import com.tracker.services.EngineerServices;

@RestController
@RequestMapping("/admin/engineers")
public class EngineerController {
	
	private EngineerServices engrServices;
	
	public EngineerController(EngineerServices engrServices) {
		this.engrServices = engrServices;
	}
	
	@GetMapping("/view-all")
	public ResponseEntity<Object> viewAll(){
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "All engineer entries successfully retrieved", engrServices.viewAllEngineers());
	}
	
	@GetMapping("/search")
	public ResponseEntity<Object> searchEngrByNameOrContact(
			@RequestParam(value = "name", required = false) String name, 
			@RequestParam(value = "contact", required = false) String contact){
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Search successful", engrServices.searchEngineerByNameOrContact(name, contact));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateEngrDetails(@RequestBody EngineerEntity engr){
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> : " + engr.getEngrId());
			
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Update successful", engrServices.updateEngineerDetails(engr));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Object> deleteEngrAcct(){
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Account successfully removed.");
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addEngrAcct(EngineerEntity engr){
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Account successfully added.",engrServices.addNewEngineer(engr));
	}

}

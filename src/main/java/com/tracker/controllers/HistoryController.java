package com.tracker.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.custom_response_handler.ResponseHandler;
import com.tracker.entities.ProductHistoryEntity;
import com.tracker.services.ProductHistoryServices;

@RestController
@RequestMapping("/history")
public class HistoryController {
	
	private ProductHistoryServices historyService;
	
	public HistoryController(ProductHistoryServices historyService) {
		this.historyService = historyService;
	}
	
	@GetMapping("/view-all")
	public ResponseEntity<Object> viewAllHistory(){
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Product histories retrieved", historyService.viewAllHistory());
	}

	@PostMapping("/update")
	public ResponseEntity<Object> updateProductHistory(@RequestBody ProductHistoryEntity history){
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Product histories retrieved", historyService.updateDeploymentHistory(history));
	}
}

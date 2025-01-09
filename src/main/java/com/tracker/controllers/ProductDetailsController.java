package com.tracker.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.custom_response_handler.ResponseHandler;
import com.tracker.entities.ProductDetailsEntity;
import com.tracker.services.ProductDetailsServices;

@RestController
@RequestMapping("/details")
public class ProductDetailsController {
	
	private ProductDetailsServices detailsService;
	
	public ProductDetailsController(ProductDetailsServices detailsService) {
		this.detailsService = detailsService;
	}
	
	@GetMapping("/view-all")
	public ResponseEntity<Object> viewAll(){
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Product details list successfully retrieved", detailsService.viewAllproductDetails());
	}
	
	@PostMapping("add")
	public ResponseEntity<Object> addNewProductDetail(@RequestBody ProductDetailsEntity productDetail){
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "New product detail listed.", detailsService.addProductDetail(productDetail));
	}

}

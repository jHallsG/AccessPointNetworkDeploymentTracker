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
import org.springframework.web.bind.annotation.RestController;

import com.tracker.custom_response_handler.ResponseHandler;
import com.tracker.entities.ProductEntity;
import com.tracker.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductServices productService;
	
	public ProductController(ProductServices productService) {
		this.productService = productService;
	}
	
	@GetMapping("/view-all")
	public ResponseEntity<Object> viewAll(){
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Product list successfully retrieved", productService.viewAllproducts());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addNewProduct(@RequestBody ProductEntity product){
		
		System.out.println("Product category is : " + product.getCategory());
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "New product added.", productService.addNewProduct(product));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateProductInfo(@RequestBody ProductEntity product){
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Product information updated.", productService.updateProductInfo(product));
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("productId") int productId){
		
		productService.deleteProduct(productId);
		
		return ResponseHandler.responseBuilder(HttpStatus.OK, "Product name successfully removed");
	}
}

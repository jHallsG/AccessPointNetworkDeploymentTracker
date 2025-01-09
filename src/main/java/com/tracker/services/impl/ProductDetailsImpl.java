package com.tracker.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tracker.entities.ProductDetailsEntity;
import com.tracker.enums.ProductDeploymentHistoryEnum;
import com.tracker.enums.ProductDetailsEnum;
import com.tracker.repositories.ProductDeploymentHistoryRepository;
import com.tracker.repositories.ProductDetailsRepository;
import com.tracker.repositories.ProductRepository;
import com.tracker.services.ProductDetailsServices;

@Service
public class ProductDetailsImpl implements ProductDetailsServices{
	
	private ProductDetailsRepository detailsRepo;
	private ProductRepository productRepo;
	private ProductDeploymentHistoryRepository productDeploymentHistory;
	
	public ProductDetailsImpl(ProductDetailsRepository detailsRepo, 
			ProductRepository productRepo, 
			ProductDeploymentHistoryRepository productDeploymentHistory) {
		this.detailsRepo = detailsRepo;
		this.productRepo = productRepo;
		this.productDeploymentHistory = productDeploymentHistory;
	}

	@Override
	public List<ProductDetailsEntity> viewAllproductDetails() {
		
		return detailsRepo.findAll();
	}

	@Override
	@Transactional
	public ProductDetailsEntity addProductDetail(ProductDetailsEntity productDetails) {
		
		ProductDetailsEntity saveProductDetails;
		
		if (productDetails.getCurrentStatus() == null || productDetails.getCurrentStatus().name().isBlank()) {
			productDetails.setCurrentStatus(ProductDetailsEnum.in_stock);
		}
		
		if (productDetails.getRemarks() == null || productDetails.getRemarks().isBlank()) {
			productDetails.setRemarks(ProductDetailsEnum.in_stock.getDescription());
		}
		
		Optional<ProductDetailsEntity> checkProductAvailability = detailsRepo.findBySerialNumber(productDetails.getSerialNumber());
		
		if (checkProductAvailability.isEmpty()) {
			// save and flush as the following transactions require the existence of this record in the database.
			saveProductDetails = detailsRepo.saveAndFlush(productDetails);
			// for every new product serial registered, increment product qty
			productRepo.incrementProductQtyPerNewProductDetails(productDetails.getProductId());
			// add product registration in history
			productDeploymentHistory.insertNewProductRegistrationHistory(productDetails.getSerialNumber(), 
					ProductDeploymentHistoryEnum.registration.name(),
					"Brand new");
		} else {
			saveProductDetails = detailsRepo.save(productDetails);
		}
		
		return saveProductDetails;
	}
	
	
}

package com.tracker.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tracker.entities.ProductHistoryEntity;
import com.tracker.repositories.ProductDeploymentHistoryRepository;
import com.tracker.repositories.ProductDetailsRepository;
import com.tracker.services.ProductHistoryServices;

@Service
public class ProductHistoryServiceImpl implements ProductHistoryServices{
	
	private ProductDeploymentHistoryRepository historyRepo;
	private ProductDetailsRepository detailsRepo;
	
	public ProductHistoryServiceImpl (ProductDeploymentHistoryRepository historyRepo, ProductDetailsRepository detailsRepo) {
		this.historyRepo = historyRepo;
		this.detailsRepo = detailsRepo;
	}

	@Override
	@Transactional
	public ProductHistoryEntity updateDeploymentHistory(ProductHistoryEntity activity) {
		
		String deploymentStatusEquivalent = "";
		
		if (activity.getEngrId() == null || activity.getEngrId().isBlank()) {
			throw new RuntimeException("Engineer ID field is required");
		}
		
		if (activity.getActivityDate() == null) {
			activity.setActivityDate(LocalDateTime.now());
		}
		
		// reflect current_status in ProductDetails page
		switch (activity.getActivity().name()) {
			case "registration": 
				deploymentStatusEquivalent = "in_stock";
				break;
			case "deployment":
				deploymentStatusEquivalent = "deployed";
				break;
			case "returned":
				deploymentStatusEquivalent = "returned";
				break;
		}
		
		detailsRepo.updateProductDeploymentStatus(deploymentStatusEquivalent, activity.getRemarks(),activity.getSerialNumber());
		
		return historyRepo.save(activity);
	}

	@Override
	public List<ProductHistoryEntity> viewAllHistory() {
		
		return historyRepo.findAll();
	}
}

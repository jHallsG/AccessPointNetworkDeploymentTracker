package com.tracker.services;

import java.util.List;

import com.tracker.entities.ProductHistoryEntity;

public interface ProductHistoryServices {
	
	ProductHistoryEntity updateDeploymentHistory(ProductHistoryEntity activity);
	
	List<ProductHistoryEntity> viewAllHistory();
	
	/* TODO:
	 * List<ProductHistoryEntity> searchHistory(String serial, String activity, String location, String engr);
	 */
}

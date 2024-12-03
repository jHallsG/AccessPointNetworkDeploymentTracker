package com.tracker.services;

import java.util.List;

import com.tracker.entities.ProductHistoryEntity;

public interface ProductHistoryServices {
	
	List<ProductHistoryEntity> viewAllHistory();
	List<ProductHistoryEntity> searchHistory(String serial, String activity, String location, String engr);
	ProductHistoryEntity addNewActivity();
}

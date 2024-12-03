package com.tracker.services;

import java.util.List;

import com.tracker.entities.ProductDetailsEntity;

public interface ProductDetailsServices {
	
	List<ProductDetailsEntity> viewAllproductDetails();
	ProductDetailsEntity addNewProductDetail();
	ProductDetailsEntity updateProductDetail();
	ProductDetailsEntity deleteProductDetail();
	ProductDetailsEntity searchproductDetails();

}

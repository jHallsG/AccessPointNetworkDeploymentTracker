package com.tracker.services;

import java.util.List;

import com.tracker.entities.ProductEntity;

public interface ProductServices {
	
	List<ProductEntity> viewAllproducts();
	ProductEntity addNewProduct();
	ProductEntity updateProductInfo();
	ProductEntity deleteProduct();

}

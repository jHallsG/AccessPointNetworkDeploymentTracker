package com.tracker.services;

import java.util.List;

import com.tracker.dto.ProductsOverviewDTO;
import com.tracker.entities.ProductEntity;

public interface ProductServices {
	
	List<ProductEntity> viewAllproducts();
	ProductEntity addNewProduct(ProductEntity product);
	ProductEntity updateProductInfo(ProductEntity product);
	void deleteProduct(int productId);
	List<ProductsOverviewDTO> getOverview();

}

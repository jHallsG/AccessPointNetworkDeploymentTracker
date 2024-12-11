package com.tracker.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tracker.entities.ProductEntity;
import com.tracker.repositories.ProductRepository;
import com.tracker.services.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices{
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductEntity> viewAllproducts() {
		
		return productRepository.findAll();
	}

	@Override
	public ProductEntity addNewProduct(ProductEntity product) {
		
		return productRepository.save(product);
	}

	@Override
	public ProductEntity updateProductInfo(ProductEntity product) {
		
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		
		productRepository.deleteById(productId);
	}

}

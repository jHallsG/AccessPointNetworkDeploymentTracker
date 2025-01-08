package com.tracker.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tracker.dto.ProductsOverviewDTO;
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

	@Override
	public List<ProductsOverviewDTO> getOverview() {
		/*
		 * productRepository.getOverview() returns an array of Objects. They contain custom fields not available in the 
		 * ProductEntity class (ie: qty_available, qty_returned, qty_deployed).
		 * Need to manually map these fields to ProductsOverviewDTO.
		 */
		// 
		List<Object[]> rawSQLQueryResults = productRepository.getOverview();
		List<ProductsOverviewDTO> mapRawResultsToDTO = new ArrayList<ProductsOverviewDTO>();
		for (Object[] item : rawSQLQueryResults) {
			mapRawResultsToDTO.add(new ProductsOverviewDTO(
					((Number) item[0]).intValue(), 
					(String) item[1], 
					(String) item[2], 
					((Number) item[3]).intValue(), 
					((Number) item[4]).intValue(), 
					((Number) item[5]).intValue(), 
					((Number) item[6]).intValue()));
		}
		
		return mapRawResultsToDTO;
	}

}

package com.tracker.entities;

import com.tracker.enums.ProductCategoryEnum;

public class ProductEntity {
	
	private int productId;
	private String productName;
	private ProductCategoryEnum category;
	private int totalQty;
	
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public ProductCategoryEnum getCategory() {
		return category;
	}
	public int getTotalQty() {
		return totalQty;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setCategory(ProductCategoryEnum category) {
		this.category = category;
	}
	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}
}

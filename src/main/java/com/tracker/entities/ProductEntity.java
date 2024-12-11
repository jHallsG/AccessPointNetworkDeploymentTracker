package com.tracker.entities;

import com.tracker.enums.ProductCategoryEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity(name = "product")
public class ProductEntity {
	
	@Id
	private int productId;
	private String productName;
	@Enumerated(EnumType.STRING)
	private ProductCategoryEnum category;
	@Column(name = "totalqty")		// column name is totalQty but MySQL is case insensitive.
									// using @Column(name = "totalQty") would be converted as total_qty in the SQL query 
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

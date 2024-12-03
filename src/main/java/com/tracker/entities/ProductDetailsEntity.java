package com.tracker.entities;

import com.tracker.enums.ProductDetailsEnum;

public class ProductDetailsEntity {
	
	private String serialNumber;
	private int productId;
	private String brand;
	private ProductDetailsEnum currentStatus;
	private String remarks;
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public int getProductId() {
		return productId;
	}
	public String getBrand() {
		return brand;
	}
	public ProductDetailsEnum getCurrentStatus() {
		return currentStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setCurrentStatus(ProductDetailsEnum currentStatus) {
		this.currentStatus = currentStatus;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}

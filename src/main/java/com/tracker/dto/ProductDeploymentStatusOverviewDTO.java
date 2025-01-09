package com.tracker.dto;

public class ProductDeploymentStatusOverviewDTO {
	
	private int productId;
	private String productName;
	private String category;
	private int qtyTotal;
	private int qtyAvailable;
	private int qtyReturned;
	private int qtyDeployed;
	
	public ProductDeploymentStatusOverviewDTO(int productId, String productName, String category, int qtyTotal, int qtyAvailable,
			int qtyReturned, int qtyDeployed) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.qtyTotal = qtyTotal;
		this.qtyAvailable = qtyAvailable;
		this.qtyReturned = qtyReturned;
		this.qtyDeployed = qtyDeployed;
	}
	
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public String getCategory() {
		return category;
	}
	public int getQtyTotal() {
		return qtyTotal;
	}
	public int getQtyAvailable() {
		return qtyAvailable;
	}
	public int getQtyReturned() {
		return qtyReturned;
	}
	public int getQtyDeployed() {
		return qtyDeployed;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setQtyTotal(int qtyTotal) {
		this.qtyTotal = qtyTotal;
	}
	public void setQtyAvailable(int qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}
	public void setQtyReturned(int qtyReturned) {
		this.qtyReturned = qtyReturned;
	}
	public void setQtyDeployed(int qtyDeployed) {
		this.qtyDeployed = qtyDeployed;
	}

}

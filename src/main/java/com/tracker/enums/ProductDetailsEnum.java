package com.tracker.enums;

public enum ProductDetailsEnum {
	
	in_stock ("Product is available and ready for deployment."),
	deployed ("Product is already deployed and operational."),
	returned ("Product has been recalled due to damage or malfunction.");
	
	private String description;
	
	ProductDetailsEnum (String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

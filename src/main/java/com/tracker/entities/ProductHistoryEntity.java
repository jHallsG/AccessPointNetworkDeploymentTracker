package com.tracker.entities;

import java.time.LocalDateTime;

import com.tracker.enums.ProductDeploymentHistoryEnum;

public class ProductHistoryEntity {
	
	private int historyId;
	private String serialNumber;
	private ProductDeploymentHistoryEnum activity;
	private LocalDateTime activityDate;
	private String location;
	private int engrId;
	private String remarks;
	
	public int getHistoryId() {
		return historyId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public ProductDeploymentHistoryEnum getActivity() {
		return activity;
	}
	public LocalDateTime getActivityDate() {
		return activityDate;
	}
	public String getLocation() {
		return location;
	}
	public int getEngrId() {
		return engrId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public void setActivity(ProductDeploymentHistoryEnum activity) {
		this.activity = activity;
	}
	public void setActivityDate(LocalDateTime activityDate) {
		this.activityDate = activityDate;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setEngrId(int engrId) {
		this.engrId = engrId;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}

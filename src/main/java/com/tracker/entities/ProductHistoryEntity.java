package com.tracker.entities;

import java.time.LocalDateTime;

import com.tracker.enums.ProductDeploymentHistoryEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity(name = "product_deployment_history")
public class ProductHistoryEntity {
	
	@Id
	private int historyId;
	private String serialNumber;
	@Enumerated(EnumType.STRING)
	private ProductDeploymentHistoryEnum activity;
	private LocalDateTime activityDate;
	@Column(name = "location_name")
	private String location;
	@Column(name = "engineer_id")
	private String engrId;
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
	public String getEngrId() {
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
	public void setEngrId(String engrId) {
		this.engrId = engrId;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}

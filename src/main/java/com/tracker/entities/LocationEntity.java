package com.tracker.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "location")
public class LocationEntity {
	
	@Id
	@Column(name = "location_id")
	private int locId;
	
	@Column(name = "location_name")
	private String locName;
	
	public int getLocId() {
		return locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
}

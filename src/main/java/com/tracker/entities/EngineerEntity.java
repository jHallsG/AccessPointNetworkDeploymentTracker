package com.tracker.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "engineer")
public class EngineerEntity {
	
	@Id
	@Column(name = "engineer_id")
	private String engrId;
	@Column(name = "engineer_name")
	private String engrName;
	private String contact;
	
	public String getEngrId() {
		return engrId;
	}
	public String getEngrName() {
		return engrName;
	}
	public String getContact() {
		return contact;
	}
	public void setEngrId(String engrId) {
		this.engrId = engrId;
	}
	public void setEngrName(String engrName) {
		this.engrName = engrName;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}

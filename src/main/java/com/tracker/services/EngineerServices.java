package com.tracker.services;

import java.util.List;

import com.tracker.entities.EngineerEntity;

public interface EngineerServices {
	
	List<EngineerEntity> viewAllEngineers();
	EngineerEntity addNewEngineer(EngineerEntity engr);
	EngineerEntity updateEngineerDetails(EngineerEntity engr);
	String deleteEngineerInfo(String engrId);
	List<EngineerEntity> searchEngineerByNameOrContact(String engrName, String contact);

}

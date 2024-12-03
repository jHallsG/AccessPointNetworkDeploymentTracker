package com.tracker.services;

import java.util.List;

import com.tracker.entities.EngineerEntity;

public interface EngineerServices {
	
	List<EngineerEntity> viewAllEngineers();
	EngineerEntity addNewEngineer();
	EngineerEntity updateEngineerDetails(String engrId);
	EngineerEntity deleteEngineerInfo(String engrId);
	EngineerEntity searchEngineer(String engrId, String engrName, String contact);

}

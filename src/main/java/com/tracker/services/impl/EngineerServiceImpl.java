package com.tracker.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tracker.custom_exception_handler.CustomEntityNotFoundException;
import com.tracker.custom_exception_handler.CustomNoSuchElementException;
import com.tracker.entities.EngineerEntity;
import com.tracker.repositories.EngineerRepository;
import com.tracker.services.EngineerServices;

@Service
public class EngineerServiceImpl implements EngineerServices {

	private EngineerRepository engrRepository;

	public EngineerServiceImpl(EngineerRepository engrRepository) {
		this.engrRepository = engrRepository;
	}

	@Override
	public List<EngineerEntity> viewAllEngineers() {

		return engrRepository.findAll();
	}

	@Override
	public EngineerEntity addNewEngineer(EngineerEntity engr) {

		return engrRepository.save(engr);
	}

	@Override
	public EngineerEntity updateEngineerDetails(EngineerEntity engr) {
		
		if (engr.getEngrId() == null) throw new IllegalArgumentException("Engineer ID must be specified"); 

		Optional<EngineerEntity> optionalEngineerRecord = engrRepository.findByEngrId(engr.getEngrId());

		if (optionalEngineerRecord.isEmpty())
			throw new CustomEntityNotFoundException ("Engineer does not exist.");

		return engrRepository.save(engr);
	}

	@Override
	public String deleteEngineerInfo(String engrId) {
		Optional<EngineerEntity> optionalEngineerRecord = engrRepository.findByEngrId(engrId);

		if (optionalEngineerRecord.isPresent()) {
			engrRepository.deleteByEngrId(engrId);
			return "Engineer : " + engrId + " successfully deleted";
		} else
			throw new CustomNoSuchElementException("Engineer does not exist.");
	}

	@Override
	public List<EngineerEntity> searchEngineerByNameOrContact(String engrName, String contact) {

		return engrRepository.findByEngrNameContainingOrContactContaining(engrName, contact);
	}

}

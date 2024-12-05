package com.tracker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.entities.EngineerEntity;

public interface EngineerRepository extends JpaRepository<EngineerEntity, Integer>{
	
	Optional<EngineerEntity> findByEngrId(String engrId);
	List<EngineerEntity> findByEngrNameContainingOrContactContaining(String name, String contact);
	void deleteByEngrId(String engrId);

}

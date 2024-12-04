package com.tracker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.entities.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity, Integer>{
	
	Optional<LocationEntity> findByLocName(String locName);
	List<LocationEntity> findByLocNameContaining(String search);

}

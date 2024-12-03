package com.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.entities.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity, Integer>{

}

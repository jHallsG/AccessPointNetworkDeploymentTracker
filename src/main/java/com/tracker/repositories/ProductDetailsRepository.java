package com.tracker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.entities.ProductDetailsEntity;

public interface ProductDetailsRepository extends JpaRepository<ProductDetailsEntity, String>{
	
	Optional<ProductDetailsEntity> findBySerialNumber(String serial);

}

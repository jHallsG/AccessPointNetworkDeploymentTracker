package com.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.entities.ProductDetailsEntity;

public interface ProductDetailsRepository extends JpaRepository<ProductDetailsEntity, String>{

}

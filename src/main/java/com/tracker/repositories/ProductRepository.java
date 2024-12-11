package com.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

}

package com.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tracker.entities.ProductHistoryEntity;

public interface ProductDeploymentHistoryRepository extends JpaRepository<ProductHistoryEntity, Integer>{
	
	@Modifying
	@Query(value = "INSERT INTO product_deployment_history (serial_number, activity, remarks) VALUES (:serial, :activity, :remarks)", nativeQuery = true)
	void insertNewProductRegistrationHistory(String serial, String activity, String remarks);
}

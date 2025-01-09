package com.tracker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tracker.entities.ProductDetailsEntity;

public interface ProductDetailsRepository extends JpaRepository<ProductDetailsEntity, String>{
	
	Optional<ProductDetailsEntity> findBySerialNumber(String serial);
	
	@Modifying
	@Query(value = "UPDATE product_details SET current_status = :deploymentStatus, remarks = :remarks WHERE serial_number = :serialNumber", nativeQuery = true)
	void updateProductDeploymentStatus(String deploymentStatus, String remarks, String serialNumber);

}

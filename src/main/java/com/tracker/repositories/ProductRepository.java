package com.tracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tracker.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	
	@Query(value = "SELECT p.*, " +
		       "COALESCE(SUM(CASE WHEN pd.current_status = 'in_stock' THEN 1 ELSE 0 END), 0) AS qty_available, " +
		       "COALESCE(SUM(CASE WHEN pd.current_status = 'returned' THEN 1 ELSE 0 END), 0) AS qty_returned, " +
		       "COALESCE(SUM(CASE WHEN pd.current_status = 'deployed' THEN 1 ELSE 0 END), 0) AS qty_deployed " +
		       "FROM product p " +
		       "LEFT JOIN product_details pd ON p.product_id = pd.product_id " +
		       "GROUP BY p.product_id, p.product_name, p.category, p.totalQty;", nativeQuery = true)
	List<Object[]> getOverview();
	
	@Modifying
	@Query(value = "UPDATE product SET totalQty = totalQty + 1 WHERE product_id = :productId", nativeQuery = true)
	void incrementProductQtyPerNewProductDetails(int productId);

}

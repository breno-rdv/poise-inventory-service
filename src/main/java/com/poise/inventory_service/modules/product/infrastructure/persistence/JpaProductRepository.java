package com.poise.inventory_service.modules.product.infrastructure.persistence;

import com.poise.inventory_service.modules.product.domain.Product;
import com.poise.inventory_service.shared.infrastructure.persistence.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaProductRepository extends BaseJpaRepository<Product, String> {
    Optional<Product> findBySku(String sku);
    boolean existsBySku(String sku);
    
    @Query("SELECT p FROM Product p WHERE p.quantity <= p.minStockLevel")
    List<Product> findLowStockProducts();
}
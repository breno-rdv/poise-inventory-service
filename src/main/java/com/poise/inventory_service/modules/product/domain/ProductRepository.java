package com.poise.inventory_service.modules.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(String id);
    Optional<Product> findBySku(String sku);
    List<Product> findAll();
    List<Product> findLowStockProducts();
    void deleteById(String id);
    boolean existsBySku(String sku);
}
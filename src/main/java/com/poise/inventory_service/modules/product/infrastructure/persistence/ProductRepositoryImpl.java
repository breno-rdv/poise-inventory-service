package com.poise.inventory_service.modules.product.infrastructure.persistence;

import com.poise.inventory_service.modules.product.domain.Product;
import com.poise.inventory_service.modules.product.domain.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    
    private final JpaProductRepository jpaRepository;
    
    public ProductRepositoryImpl(JpaProductRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Product save(Product product) {
        return jpaRepository.save(product);
    }
    
    @Override
    public Optional<Product> findById(String id) {
        return jpaRepository.findById(id);
    }
    
    @Override
    public Optional<Product> findBySku(String sku) {
        return jpaRepository.findBySku(sku);
    }
    
    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll();
    }
    
    @Override
    public List<Product> findLowStockProducts() {
        return jpaRepository.findLowStockProducts();
    }
    
    @Override
    public void deleteById(String id) {
        jpaRepository.deleteById(id);
    }
    
    @Override
    public boolean existsBySku(String sku) {
        return jpaRepository.existsBySku(sku);
    }
}
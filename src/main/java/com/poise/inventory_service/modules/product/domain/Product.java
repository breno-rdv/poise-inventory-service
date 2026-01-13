package com.poise.inventory_service.modules.product.domain;

import com.poise.inventory_service.shared.domain.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String sku;
    
    private String description;
    
    @Column(nullable = false)
    private Integer quantity;
    
    @Column(name = "min_stock_level")
    private Integer minStockLevel;
    
    protected Product() {}
    
    public Product(String name, String sku, String description, Integer quantity, Integer minStockLevel) {
        super();
        this.name = name;
        this.sku = sku;
        this.description = description;
        this.quantity = quantity;
        this.minStockLevel = minStockLevel;
    }
    
    public void updateQuantity(Integer newQuantity) {
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = newQuantity;
    }
    
    public boolean isLowStock() {
        return quantity <= minStockLevel;
    }
    
    // Getters
    public String getName() { return name; }
    public String getSku() { return sku; }
    public String getDescription() { return description; }
    public Integer getQuantity() { return quantity; }
    public Integer getMinStockLevel() { return minStockLevel; }
}
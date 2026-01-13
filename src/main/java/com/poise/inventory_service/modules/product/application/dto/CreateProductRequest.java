package com.poise.inventory_service.modules.product.application.dto;

public record CreateProductRequest(
    String name,
    String sku,
    String description,
    Integer quantity,
    Integer minStockLevel
) {}
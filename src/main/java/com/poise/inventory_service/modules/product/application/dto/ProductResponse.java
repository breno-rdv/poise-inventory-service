package com.poise.inventory_service.modules.product.application.dto;

import java.time.LocalDateTime;

public record ProductResponse(
    String id,
    String name,
    String sku,
    String description,
    Integer quantity,
    Integer minStockLevel,
    boolean lowStock,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
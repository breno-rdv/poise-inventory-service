package com.poise.inventory_service.modules.product.application.usecases;

import com.poise.inventory_service.modules.product.application.dto.CreateProductRequest;
import com.poise.inventory_service.modules.product.application.dto.ProductResponse;
import com.poise.inventory_service.modules.product.domain.Product;
import com.poise.inventory_service.modules.product.domain.ProductRepository;
import com.poise.inventory_service.shared.application.UseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateProductUseCase implements UseCase<CreateProductRequest, ProductResponse> {
    
    private final ProductRepository productRepository;
    
    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public ProductResponse execute(CreateProductRequest request) {
        if (productRepository.existsBySku(request.sku())) {
            throw new IllegalArgumentException("Product with SKU " + request.sku() + " already exists");
        }
        
        Product product = new Product(
            request.name(),
            request.sku(),
            request.description(),
            request.quantity(),
            request.minStockLevel()
        );
        
        Product savedProduct = productRepository.save(product);
        
        return new ProductResponse(
            savedProduct.getId(),
            savedProduct.getName(),
            savedProduct.getSku(),
            savedProduct.getDescription(),
            savedProduct.getQuantity(),
            savedProduct.getMinStockLevel(),
            savedProduct.isLowStock(),
            savedProduct.getCreatedAt(),
            savedProduct.getUpdatedAt()
        );
    }
}
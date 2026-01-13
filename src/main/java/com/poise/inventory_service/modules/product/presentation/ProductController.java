package com.poise.inventory_service.modules.product.presentation;

import com.poise.inventory_service.modules.product.application.dto.CreateProductRequest;
import com.poise.inventory_service.modules.product.application.dto.ProductResponse;
import com.poise.inventory_service.modules.product.application.usecases.CreateProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    
    private final CreateProductUseCase createProductUseCase;
    
    public ProductController(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }
    
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) {
        ProductResponse response = createProductUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
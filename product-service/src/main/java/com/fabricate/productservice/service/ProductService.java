package com.fabricate.productservice.service;

import java.util.List;

import com.fabricate.productservice.dto.ProductRequest;
import com.fabricate.productservice.dto.ProductResponse;

public interface ProductService {
    
    public void saveProduct(ProductRequest productRequest);
    public ProductResponse getProduct(String productId);
    public List<ProductResponse> getAllProducts();
    public void updateProduct(String productId, ProductRequest productRequest);
    public void deleteProduct(String productId);
}

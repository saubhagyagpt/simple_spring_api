package com.fabricate.productservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fabricate.productservice.dto.ProductRequest;
import com.fabricate.productservice.dto.ProductResponse;
import com.fabricate.productservice.exception.ResourceNotFoundException;
import com.fabricate.productservice.model.Product;
import com.fabricate.productservice.repo.ProductRepo;
import com.fabricate.productservice.service.ProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;
    private ModelMapper modelMapper;

    @Override
    public void saveProduct(ProductRequest productRequest) {
        productRepo.save(modelMapper.map(productRequest,Product.class));
    }

    @Override
    public ProductResponse getProduct(String productId) {
        Product product = productRepo.findById(productId).orElseThrow(
        () -> new ResourceNotFoundException("Product","ProductId",productId));
        return modelMapper.map(product,ProductResponse.class);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(product -> modelMapper.map(product,ProductResponse.class)).toList();
    }

    @Override
    public void updateProduct(String productId, ProductRequest productRequest) {
        Product product = productRepo.findById(productId).orElseThrow(
            ()-> new ResourceNotFoundException("Product", "Product Id", productId));

        product.setProductName(productRequest.getProductName());
        product.setProductDescription(productRequest.getProductDescription());
        product.setProductPrice(productRequest.getProductPrice());
        productRepo.save(product);   
    }

    @Override
    public void deleteProduct(String productId) {
        Product product = productRepo.findById(productId).orElseThrow(
            ()-> new ResourceNotFoundException("Product", "Product Id", productId));
        System.out.println(product);
        productRepo.deleteById(productId);
    } 
}

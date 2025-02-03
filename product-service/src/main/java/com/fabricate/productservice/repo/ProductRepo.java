package com.fabricate.productservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabricate.productservice.model.Product;

public interface ProductRepo extends JpaRepository<Product,String>{
    
}

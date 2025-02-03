package com.fabricate.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabricate.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
    
}

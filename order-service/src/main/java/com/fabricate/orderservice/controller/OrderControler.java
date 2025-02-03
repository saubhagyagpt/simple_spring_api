package com.fabricate.orderservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fabricate.orderservice.dto.OrderRequest;
import com.fabricate.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderControler {
    
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest){

        orderService.placeOrder(orderRequest);
        return new ResponseEntity<>("Order is Placed successfully", HttpStatus.CREATED);
    }
    
}

package com.fabricate.orderservice.service.impl;
import java.util.UUID;

import com.fabricate.orderservice.dto.OrderLineItemsDto;
import com.fabricate.orderservice.dto.OrderRequest;
import com.fabricate.orderservice.model.Order;
import com.fabricate.orderservice.model.OrderLineItems;
import com.fabricate.orderservice.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public void placeOrder(OrderRequest OrderRequest) {
        
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        OrderRequest.getOrderLineItemsDto()
        .stream()
        .map(orderLineItemDto -> mapToDto(orderLineItemDto))
        .toList();
    }

    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemDto){

        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItemDto.setSkuCode(orderLineItemDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemDto.getPrice());
        orderLineItems.setQuantity(orderLineItemDto.getQuantity());
        return orderLineItems;
    }
    
}

package com.jwt.test.demo.service;

import com.jwt.test.demo.domain.Order;
import com.jwt.test.demo.payload.request.OrderCreateRequest;

import java.util.Optional;

public interface OrderService {
    Order saveOrder(OrderCreateRequest orderCreateRequest);
    Optional<Order> findOrderById(Long id);
    void deleteOrderById(Long id);

}

package com.jwt.test.demo.service;

import com.jwt.test.demo.domain.Order;
import com.jwt.test.demo.domain.OrderStatus;
import com.jwt.test.demo.payload.request.OrderCreateRequest;
import com.jwt.test.demo.payload.response.OrderHistoryResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order saveOrder(OrderCreateRequest orderCreateRequest);
    Optional<Order> findOrderById(Long id);
    void deleteOrderById(Long id);
    List<Order> getAllOrders();
    List<Order> getAllOrdersByStatus(OrderStatus orderStatus);
    List<OrderHistoryResponse> getOrderFromUser(String username);
    void updateOrderStatus(Long id);
}

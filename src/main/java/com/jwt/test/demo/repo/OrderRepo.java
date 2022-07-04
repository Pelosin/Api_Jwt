package com.jwt.test.demo.repo;

import com.jwt.test.demo.domain.Order;
import com.jwt.test.demo.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> getByStatus(OrderStatus status);
}

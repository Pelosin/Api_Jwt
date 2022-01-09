package com.jwt.test.demo.repo;

import com.jwt.test.demo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {

}

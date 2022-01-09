package com.jwt.test.demo.service.serviceImplementation;

import com.jwt.test.demo.domain.Order;
import com.jwt.test.demo.mapper.OrderMapper;
import com.jwt.test.demo.payload.request.OrderCreateRequest;
import com.jwt.test.demo.repo.OrderRepo;
import com.jwt.test.demo.service.OrderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrderServiceImpl implements OrderService {

    private final @NonNull OrderMapper orderMapper;
    private final @NonNull OrderRepo orderRepo;

    @Override
    public Order saveOrder(OrderCreateRequest orderCreateRequest) {

        Order orderToBeSaved = orderMapper.toOrder(orderCreateRequest);

        return orderRepo.save(orderToBeSaved);
    }

    @Override
    public Optional<Order> findOrderById(Long id) {
        Optional<Order> order = orderRepo.findById(id); 
        return order;
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepo.delete(findOrderById(id).get());
    }
}

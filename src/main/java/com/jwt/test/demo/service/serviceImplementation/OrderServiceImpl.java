package com.jwt.test.demo.service.serviceImplementation;

import com.jwt.test.demo.domain.Order;
import com.jwt.test.demo.domain.OrderStatus;
import com.jwt.test.demo.domain.User;
import com.jwt.test.demo.mapper.OrderMapper;
import com.jwt.test.demo.payload.request.OrderCreateRequest;
import com.jwt.test.demo.payload.response.OrderHistoryResponse;
import com.jwt.test.demo.repo.OrderRepo;
import com.jwt.test.demo.service.OrderService;
import com.jwt.test.demo.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrderServiceImpl implements OrderService {

    private final @NonNull OrderMapper orderMapper;
    private final @NonNull OrderRepo orderRepo;
    private final @NonNull UserService userService;

    @Override
    public Order saveOrder(OrderCreateRequest orderCreateRequest) {
        Order orderToBeSaved = orderMapper.toOrder(orderCreateRequest);
        log.info("Saving order {} ", orderToBeSaved.toString());
        return orderRepo.save(orderToBeSaved);
    }

    @Override
    public Optional<Order> findOrderById(Long id) {
        return orderRepo.findById(id);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepo.delete(findOrderById(id).get());
    }

    @Override
    public List<Order> getAllOrders() {
        log.info("Getting all orders");
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getAllOrdersByStatus(OrderStatus orderStatus) {
        return orderRepo.getByStatus(orderStatus);
    }

    @Override
    public List<OrderHistoryResponse> getOrderFromUser(String username) {
        User user = userService.getUserByUsername(username);

        return orderMapper.toOrderHistoryResponseList(user.getOrderList());
    }

    @Override
    public void updateOrderStatus(Long id) {
        Order orderRepoById = orderRepo.getById(id);
        orderRepoById.setStatus(OrderStatus.DONE);
        orderRepo.save(orderRepoById);
    }
}

package com.jwt.test.demo.repo;

import com.jwt.test.demo.domain.Order;
import com.jwt.test.demo.domain.OrderStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

@DataJpaTest
@DisplayName("Test for orderRepo")
class OrderRepoTest {

    @Autowired
    private OrderRepo orderRepo;

    @Test
    @DisplayName("Save presist oreder when successful")
    public void save_PersistOrder_WhenSuccessful(){
        Order orderToBeSaved = createOrder();
        Order savedOrder = orderRepo.save(orderToBeSaved);
        Assertions.assertThat(savedOrder).isNotNull();
        Assertions.assertThat(orderToBeSaved).isEqualTo(savedOrder);
    }

    @Test
    @DisplayName("FindById returns order when successful")
    public void findById_ReturnsOrder_WhenSuccessful(){
        Order orderToBeSaved = createOrder();
        orderRepo.save(orderToBeSaved);
        Optional<Order> savedOrder = orderRepo.findById(orderToBeSaved.getId());
        Assertions.assertThat(savedOrder).isNotNull();
        Assertions.assertThat(orderToBeSaved).isEqualTo(savedOrder);
    }

    @Test
    @DisplayName("Delete order when successful")
    public void delete_DeleteOrder_WhenSuccessful(){
        Order orderToBeSaved = createOrder();
        orderRepo.save(orderToBeSaved);
        orderRepo.delete(orderToBeSaved);
        Optional<Order> orderOptional = orderRepo.findById(orderToBeSaved.getId());
        Assertions.assertThat(orderOptional).isEmpty();
    }

    @Test
    @DisplayName("Save updates order when successful")
    public void save_UpdatesOrder_WhenSuccessful(){
        Order orderToBeSaved = createOrder();

        Order savedOrder = orderRepo.save(orderToBeSaved);

        savedOrder.setStatus(OrderStatus.DONE);

        Order updatedOrder = orderRepo.save(savedOrder);

        Assertions.assertThat(updatedOrder).isNotNull();
        Assertions.assertThat(updatedOrder.getId()).isNotNull();
        Assertions.assertThat(updatedOrder.getStatus()).isEqualTo(savedOrder.getStatus());

    }

    public Order createOrder(){
        return Order.builder()
                .lineOrderList(null)
                .price(new BigDecimal(13.55))
                .status(OrderStatus.SUBMIT)
                .build();

    }

}
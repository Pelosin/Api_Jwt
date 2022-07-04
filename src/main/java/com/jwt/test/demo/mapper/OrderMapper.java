package com.jwt.test.demo.mapper;

import com.jwt.test.demo.config.security.JwtUtil;
import com.jwt.test.demo.domain.*;
import com.jwt.test.demo.exception.BadRequestException;
import com.jwt.test.demo.payload.request.LineOrderCreateRequest;
import com.jwt.test.demo.payload.request.OrderCreateRequest;
import com.jwt.test.demo.payload.response.OrderHistoryResponse;
import com.jwt.test.demo.repo.FoodRepo;
import com.jwt.test.demo.repo.TableRepo;
import com.jwt.test.demo.repo.UserRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class OrderMapper {


    private final @NonNull FoodRepo foodRepo;
    private final @NonNull TableRepo tableRepo;
    private final @NonNull UserRepo userRepo;
    private final @NonNull JwtUtil jwtUtil;

    public Order toOrder(OrderCreateRequest orderCreateRequest) {
        List<LineOrder> lineOrderList = new ArrayList<>();
        for (LineOrderCreateRequest lineOrderCreateRequest : orderCreateRequest.getLineOrderRequestList()) {
            Food food = foodRepo.findByName(lineOrderCreateRequest.getName());
            LineOrder lineOrder = new LineOrder(null, food, lineOrderCreateRequest.getQuantity());
            lineOrderList.add(lineOrder);
        }

        Order order = Order.builder()
                .lineOrderList(lineOrderList)
                .price(orderCreateRequest.getPrice())
                .status(OrderStatus.SUBMIT)
                .tableToServe(tableRepo.findById(orderCreateRequest.getTableId()).get())
                .build();

        if (!order.getTableToServe().isOccupied()) {
            throw new BadRequestException("The table is not occupied");
        } else {
//            log.info(jwtUtil.extractUsername(orderCreateRequest.getToken()));
//            User userOrder = userRepo.findByUsername(jwtUtil.extractUsername(orderCreateRequest.getToken()));
//            userOrder.getOrderList().add(order);
//            userRepo.save(userOrder);

            return order;
        }
    }

    public List<OrderHistoryResponse> toOrderHistoryResponseList(List<Order> orderList) {
        List<OrderHistoryResponse> orderHistoryResponseList = new ArrayList<>();
        for (Order order: orderList){
            orderHistoryResponseList.add(OrderHistoryResponse.builder()
                    .id(order.getId())
                    .price(order.getPrice())
                    .tableServed(order.getTableToServe().getTableNumber())
                    .createdDate(order.getCreatedDateTime())
                    .build());
        }
        return orderHistoryResponseList;
    }
}

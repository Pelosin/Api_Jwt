package com.jwt.test.demo.mapper;

import com.jwt.test.demo.domain.Food;
import com.jwt.test.demo.domain.LineOrder;
import com.jwt.test.demo.domain.Order;
import com.jwt.test.demo.domain.OrderStatus;
import com.jwt.test.demo.payload.request.LineOrderCreateRequest;
import com.jwt.test.demo.payload.request.OrderCreateRequest;
import com.jwt.test.demo.repo.FoodRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {


    private final @NonNull FoodRepo foodRepo;

    public Order toOrder(OrderCreateRequest orderCreateRequest){
        List<LineOrder> lineOrderList = new ArrayList<>();
        for (LineOrderCreateRequest lineOrderCreateRequest : orderCreateRequest.getLineOrderRequestList()) {
            Food food = foodRepo.findByName(lineOrderCreateRequest.getName());
            LineOrder lineOrder = new LineOrder(null,food, lineOrderCreateRequest.getQuantity());
            lineOrderList.add(lineOrder);
        }

        return new Order(null, lineOrderList, orderCreateRequest.getPrice(), OrderStatus.SUBMIT);
    }
}

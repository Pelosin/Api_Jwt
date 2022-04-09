package com.jwt.test.demo.api;

import com.jwt.test.demo.domain.Order;
import com.jwt.test.demo.payload.request.OrderCreateRequest;
import com.jwt.test.demo.service.OrderService;
import com.jwt.test.demo.service.serviceImplementation.OrderServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final @NonNull OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody OrderCreateRequest orderCreateRequest){
        return new ResponseEntity<>(orderService.saveOrder(orderCreateRequest), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}

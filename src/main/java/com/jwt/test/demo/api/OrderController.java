package com.jwt.test.demo.api;

import com.jwt.test.demo.domain.Order;
import com.jwt.test.demo.payload.request.OrderCreateRequest;
import com.jwt.test.demo.service.OrderService;
import com.jwt.test.demo.service.serviceImplementation.OrderServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private SimpMessagingTemplate template;

    private final @NonNull OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody OrderCreateRequest orderCreateRequest){
        Order savedOrder = orderService.saveOrder(orderCreateRequest);
        template.convertAndSend("/topic/order", savedOrder);
        return new ResponseEntity<>(orderService.saveOrder(orderCreateRequest), HttpStatus.CREATED);
    }

    @MessageMapping("/sendOrder")
    public void receiveOrder(@Payload Order order) {
        // receive order from client
    }

    @SendTo("/topic/order")
    public Order broadcastOrder(@Payload Order order) {
        return order;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}

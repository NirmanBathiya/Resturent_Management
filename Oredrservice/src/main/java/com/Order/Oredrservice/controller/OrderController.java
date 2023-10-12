package com.Order.Oredrservice.controller;

import com.Order.Oredrservice.response.OrderResponse;
import com.Order.Oredrservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{userId}")
    public ResponseEntity<OrderResponse> getOrderByUserId(@PathVariable("userId") int userId){
        OrderResponse orderResponse = orderService.findUserByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }


}

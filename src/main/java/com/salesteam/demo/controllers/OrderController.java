package com.salesteam.demo.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.salesteam.demo.models.Order;
import com.salesteam.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    // orders/order/{id} - Returns the order and its customer with the given order number
    @GetMapping(value="/order/{ordnum}",produces = {"application/json"})
    public ResponseEntity<?> findOrderById(@PathVariable long ordnum){
        Order o = orderService.findOrderById(ordnum);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

}

package com.salesteam.demo.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.salesteam.demo.models.Order;
import com.salesteam.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    // orders/all - returns all orders
    @GetMapping(value="/all", produces = {"application/json"})
    public ResponseEntity<?> getAllOrders(){
        List<Order> rtnList = orderService.findAllOrders();
        return new ResponseEntity<>(rtnList,HttpStatus.OK);
    }

    // orders/order/{id} - Returns the order and its customer with the given order number
    @GetMapping(value="/order/{ordnum}",produces = {"application/json"})
    public ResponseEntity<?> findOrderById(@PathVariable long ordnum){
        Order o = orderService.findOrderById(ordnum);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    // orders/advanceamount/{amount} - Returns the all advance amounts greater than the parameter
    @GetMapping(value="/advanceamount/{amount}", produces = {"application/json"})
    public ResponseEntity<?> findByAdvanceAmt(@PathVariable double amount){
        List<Order> rtnList = orderService.findByAdvanceAmt(amount);
        return new ResponseEntity<>(rtnList,HttpStatus.OK);
    }

    // DELETE /orders/order/{ordername} - deletes the given order
    @DeleteMapping(value="/order/{id}")
    public ResponseEntity<?> deleteOrderByNumber(@PathVariable long id){
        orderService.deleteByNumber(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}

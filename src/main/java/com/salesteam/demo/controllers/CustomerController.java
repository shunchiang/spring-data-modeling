package com.salesteam.demo.controllers;

import com.salesteam.demo.models.Customer;
import com.salesteam.demo.services.CustomerService;
import com.salesteam.demo.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired CustomerService customerService;
    // customers/orders - get all customers with their orders
    @GetMapping(value="orders",produces={"application/json"})
    public ResponseEntity<?>listAllOrders(){
        List<Customer> rtnList = customerService.findAllOrders();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }


    // customers/customer/{id} - Returns the customer and their orders with the given customer id

    // customers/namelike/{likename} - Returns all customers and their orders with a customer name containing the given substring
}

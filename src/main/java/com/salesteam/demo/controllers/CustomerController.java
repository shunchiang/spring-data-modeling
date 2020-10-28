package com.salesteam.demo.controllers;

import com.salesteam.demo.models.Customer;
import com.salesteam.demo.services.CustomerService;
import com.salesteam.demo.services.CustomerServiceImpl;
import com.salesteam.demo.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    // customers/orders - get all customers with their orders
    @GetMapping(value = "orders", produces = {"application/json"})
    public ResponseEntity<?> listAllOrders() {
        List<Customer> rtnList = customerService.findAllOrders();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

    // customers/orders/count - get all customers and their order count
    @GetMapping(value="/orders/count", produces = {"application/json"})
    public ResponseEntity<?>listOrdersCount(){
        List<OrderCounts> rtnList = customerService.findOrdersCount();
        return new ResponseEntity<>(rtnList,HttpStatus.OK);
    }

    // customers/customer/{id} - Returns the customer and their orders with the given customer id
    @GetMapping(value = "/customer/{customerid}", produces = {"application/json"})
    public ResponseEntity<?> findCustomerById(@PathVariable long customerid) {
        Customer c = customerService.findCustomerById(customerid);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    // customers/namelike/{likename} - Returns all customers and their orders with a customer name containing the given substring
    @GetMapping(value = "/namelike/{likename}", produces = {"application/json"})
    public ResponseEntity<?> findCustomerByName(@PathVariable String likename) {
        List<Customer> rtnList = customerService.findCustomerByName(likename);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }
}

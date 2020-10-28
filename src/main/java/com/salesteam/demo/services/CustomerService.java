package com.salesteam.demo.services;

import com.salesteam.demo.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> findAllOrders();

    Customer findCustomerById(long customerid);

    List<Customer> findCustomerByName(String likename);

}

package com.salesteam.demo.services;

import com.salesteam.demo.models.Customer;
import com.salesteam.demo.views.OrderCounts;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> findAllOrders();

    Customer findCustomerById(long customerid);

    List<Customer> findCustomerByName(String likename);

    List<OrderCounts> findOrdersCount();

    void deleteCustomer(long customerid);

    Customer update(Customer updateCustomer, long custcode);
}

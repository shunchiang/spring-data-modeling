package com.salesteam.demo.services;

import com.salesteam.demo.models.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    Order findOrderById(long ordnum);

    List<Order> findByAdvanceAmt(double amount);

    List<Order> findAllOrders();

    void deleteByNumber(long id);
}

package com.salesteam.demo.services;

import com.salesteam.demo.models.Order;

public interface OrderService {
    Order save(Order order);

    Order findOrderById(long ordnum);
}

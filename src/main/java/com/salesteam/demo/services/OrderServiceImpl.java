package com.salesteam.demo.services;

import com.salesteam.demo.models.Order;
import com.salesteam.demo.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersRepository ordersrepos;

    @Override
    public Order save(Order order) {
        return ordersrepos.save(order);
    }
}

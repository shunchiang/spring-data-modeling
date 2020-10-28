package com.salesteam.demo.services;

import com.salesteam.demo.models.Order;
import com.salesteam.demo.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersRepository ordersrepos;

    @Override
    public Order save(Order order) {
        return ordersrepos.save(order);
    }

    @Override
    public Order findOrderById(long ordnum) {
        return ordersrepos.findById(ordnum).orElseThrow(()->new EntityNotFoundException("Order not found"));
    }

    @Override
    public List<Order> findByAdvanceAmt(double amount) {
        return ordersrepos.findByAdvanceamountGreaterThan(amount);
    }
}

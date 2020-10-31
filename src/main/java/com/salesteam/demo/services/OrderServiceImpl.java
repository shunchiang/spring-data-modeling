package com.salesteam.demo.services;

import com.salesteam.demo.models.Order;
import com.salesteam.demo.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersRepository ordersrepos;

    @Override
    public List<Order> findAllOrders() {
        List<Order> rtnList = new ArrayList<>();
        ordersrepos.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    @Transactional
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

    @Transactional
    @Override
    public void deleteByNumber(long id) {

            if(ordersrepos.findById(id).isPresent()){
                ordersrepos.deleteById(id);
            }else{
                throw new EntityNotFoundException("Order with id: " + id + " not found");
            }

    }
}

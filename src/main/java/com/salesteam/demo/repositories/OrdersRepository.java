package com.salesteam.demo.repositories;

import com.salesteam.demo.models.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Order,Long> {
    List<Order> findByAdvanceamountGreaterThan(double amount);
}

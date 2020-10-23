package com.salesteam.demo.repositories;

import com.salesteam.demo.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order,Long> {
}

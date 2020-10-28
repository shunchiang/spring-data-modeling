package com.salesteam.demo.repositories;

import com.salesteam.demo.models.Customer;
import com.salesteam.demo.views.OrderCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer,Long>  {
    List<Customer> findByCustnameContainingIgnoringCase(String likename);

    @Query(value="SELECT c.custname name, count(o.ordnum) count " +
            "FROM customers c LEFT JOIN orders o " +
            "ON c.custcode = o.custcode " +
            "GROUP BY c.custname", nativeQuery = true)
    List<OrderCounts>findOrderCounts();
}

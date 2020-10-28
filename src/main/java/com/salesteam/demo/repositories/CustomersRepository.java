package com.salesteam.demo.repositories;

import com.salesteam.demo.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer,Long>  {
    List<Customer> findByCustnameContainingIgnoringCase(String likename);

}

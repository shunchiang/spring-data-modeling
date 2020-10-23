package com.salesteam.demo.repositories;

import com.salesteam.demo.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer,Long>  {
}

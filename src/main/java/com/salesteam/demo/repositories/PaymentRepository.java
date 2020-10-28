package com.salesteam.demo.repositories;

import com.salesteam.demo.models.Customer;
import com.salesteam.demo.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Long> {

}

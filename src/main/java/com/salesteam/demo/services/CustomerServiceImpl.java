package com.salesteam.demo.services;

import com.salesteam.demo.models.Customer;
import com.salesteam.demo.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomersRepository custrepos;
    @Override
    public Customer save(Customer customer){
        return custrepos.save(customer);
    }

}

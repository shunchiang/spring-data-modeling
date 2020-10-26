package com.salesteam.demo.services;

import com.salesteam.demo.models.Customer;
import com.salesteam.demo.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomersRepository custrepos;
    @Override
    public Customer save(Customer customer){
        return custrepos.save(customer);
    }

    @Override
    public List<Customer> findAllOrders() {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}

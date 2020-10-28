package com.salesteam.demo.services;

import com.salesteam.demo.models.Customer;
import com.salesteam.demo.repositories.CustomersRepository;
import com.salesteam.demo.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public Customer findCustomerById(long customerid) {
       return custrepos.findById(customerid).orElseThrow(()->new EntityNotFoundException("Customer " + customerid + "not found"));

    }
    @Override
    public List<Customer> findCustomerByName(String custname) {
        List <Customer> list = custrepos.findByCustnameContainingIgnoringCase(custname);
        return list;
    }

    @Override
    public List<OrderCounts> findOrdersCount() {
        List<OrderCounts> list = custrepos.findOrderCounts();
        return list;
    }
}

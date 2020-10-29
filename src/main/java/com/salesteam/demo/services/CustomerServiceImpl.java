package com.salesteam.demo.services;

import com.salesteam.demo.models.Customer;
import com.salesteam.demo.models.Order;
import com.salesteam.demo.models.Payment;
import com.salesteam.demo.repositories.CustomersRepository;
import com.salesteam.demo.repositories.OrdersRepository;
import com.salesteam.demo.repositories.PaymentRepository;
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
    @Autowired
    PaymentRepository payrepos;
    @Autowired
    OrdersRepository ordersrepos;
    @Transactional
    @Override
    public Customer save(Customer customer){
        Customer newCustomer = new Customer();

        if(newCustomer.getCustcode()!=0){
            custrepos.findById(customer.getCustcode())
                    .orElseThrow(()->new EntityNotFoundException("customer not found"));
            newCustomer.setCustcode((customer.getCustcode()));
        }

        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setAgent(customer.getAgent());

        newCustomer.getOrders().clear();
        for (Order o : customer.getOrders())
        {
            Order newOrder = new Order(o.getOrdamount(), o.getAdvanceamount(), newCustomer, o.getOrderdescription());


            for(Payment p : o.getPayments())
            {
                Payment newPayment = payrepos.findById(p.getPaymentid())
                        .orElseThrow(() -> new EntityNotFoundException("Payment " + p.getPaymentid() + " not found!"));

                newOrder.getPayments().add(newPayment);
            }

            newCustomer.getOrders().add(newOrder);
        }
        return custrepos.save(newCustomer);
    }

    @Transactional
    @Override
    public Customer update(Customer updateCustomer, long custcode) {
        Customer newUpdateCustomer = findCustomerById(custcode);

        if (updateCustomer.getCustname() != null){
            newUpdateCustomer.setCustname(updateCustomer.getCustname());
        }
        if (updateCustomer.getCustcity()!=null){
            newUpdateCustomer.setCustcity(updateCustomer.getCustcity());
        }
        if (updateCustomer.getCustcountry()!=null){
        newUpdateCustomer.setCustcountry(updateCustomer.getCustcountry());
        }
        if(updateCustomer.getGrade()!=null){
        newUpdateCustomer.setGrade(updateCustomer.getGrade());
        }
        if(updateCustomer.hasvalueforopening){
        newUpdateCustomer.setOpeningamt(updateCustomer.getOpeningamt());
        }
        if(updateCustomer.hasoutstanding){
        newUpdateCustomer.setOutstandingamt(updateCustomer.getOutstandingamt());
        }
        if(updateCustomer.hasvalueforpayment){
        newUpdateCustomer.setPaymentamt(updateCustomer.getPaymentamt());
        }
        if(updateCustomer.getPhone()!=null){
        newUpdateCustomer.setPhone(updateCustomer.getPhone());
        }
        if(updateCustomer.hasvalueforreceive){
        newUpdateCustomer.setReceiveamt(updateCustomer.getReceiveamt());
        }
        if(updateCustomer.getWorkingarea()!=null){
        newUpdateCustomer.setWorkingarea(updateCustomer.getWorkingarea());
        }
        if(updateCustomer.getAgent()!=null){
        newUpdateCustomer.setAgent(updateCustomer.getAgent());
        }

        if (updateCustomer.getOrders().size()>0){
            newUpdateCustomer.getOrders().clear();

            for (Order o : updateCustomer.getOrders())
        {
            Order newOrder = new Order(o.getOrdamount(), o.getAdvanceamount(), newUpdateCustomer, o.getOrderdescription());


            for(Payment p : o.getPayments())
            {
                Payment newPayment = payrepos.findById(p.getPaymentid())
                        .orElseThrow(() -> new EntityNotFoundException("Payment " + p.getPaymentid() + " not found!"));

                newOrder.getPayments().add(newPayment);
            }

            newUpdateCustomer.getOrders().add(newOrder);
        }
        }
        return custrepos.save(newUpdateCustomer);
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
    @Transactional
    @Override
    public void deleteCustomer(long customerid) {
        if(custrepos.findById(customerid).isPresent()){
            custrepos.deleteById(customerid);
        }else{
            throw new EntityNotFoundException("Customer with that id not found");
        }
    }
}

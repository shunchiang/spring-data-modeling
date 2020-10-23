package com.salesteam.demo.services;

import com.salesteam.demo.models.Payment;
import com.salesteam.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="paymentService")
public class PaymentServiceImpl implements  PaymentService{
    @Autowired
    PaymentRepository paymentrepos;
    @Override
    public Payment save(Payment payment) {
        return paymentrepos.save(payment);
    }
}

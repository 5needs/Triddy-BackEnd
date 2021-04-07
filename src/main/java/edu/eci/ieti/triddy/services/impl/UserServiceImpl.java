package edu.eci.ieti.triddy.services.impl;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Payment;
import edu.eci.ieti.triddy.repository.PaymentRepository;
import edu.eci.ieti.triddy.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void addPayment(Payment payment){
        paymentRepository.save(payment);
    }

    @Override
    public synchronized Payment getPaymentById(String idPayment) throws TriddyServiceException {
        Payment payment = paymentRepository.findByIdPayment(idPayment);
        if (payment != null){
            return payment;
        }else{
            throw new TriddyServiceException("Payment with Id: "+idPayment+" is not registered");
        }
    }

    @Override
    public synchronized void deletePaymentById(String idPayment) throws TriddyServiceException {
        Payment payment = getPaymentById(idPayment);
        paymentRepository.deleteByIdPayment(payment.getIdPayment());
    }

}

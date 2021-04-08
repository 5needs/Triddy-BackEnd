package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Payment;

public interface PaymentService {

    void addPayment(Payment payment);

    Payment getPaymentById(String idPayment) throws TriddyServiceException;

    void deletePaymentById(String idPayment) throws TriddyServiceException;
}

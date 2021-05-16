package edu.eci.ieti.triddy.services.impl;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Payment;
import edu.eci.ieti.triddy.repository.PaymentRepository;
import edu.eci.ieti.triddy.services.PaymentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    @AfterEach
    void deletePayments(){
        paymentRepository.deleteAll();
    }

    @Test
    public void addPayment(){
        try {
            Payment payment = new Payment("02-04-2021 08:40:30 +1234",423000.0,"54321","1234");
            paymentService.addPayment(payment);
            assertNotNull(paymentService.getPaymentById("02-04-2021 08:40:30 +1234"));
        } catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Payment with Id:"));
        }
    }

    @Test
    public void getPaymentById() {
        try {
            Payment payment2 = new Payment("999",423000.0,"54321","1234");
            paymentService.addPayment(payment2);
            Payment payment = paymentService.getPaymentById("9999");
            assertEquals("9999",payment.getIdPayment());
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Payment with Id:"));
        }
    }

    @Test
    public void deletePaymentById() {
        try {
            Payment payment2 = new Payment("02-04-2021 08:40:30 +1239",423000.0,"54321","1234");
            paymentService.addPayment(payment2);
            paymentService.deletePaymentById(payment2.getIdPayment());
            Payment payment3 = paymentService.getPaymentById(payment2.getIdPayment());
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Payment with Id:"));
        }
    }




}

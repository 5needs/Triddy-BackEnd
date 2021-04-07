package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.model.Payment;
import edu.eci.ieti.triddy.repository.PaymentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class PaymentControllerTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PaymentController paymentController;

    @AfterEach
    void deletePayments(){
        paymentRepository.deleteAll();
    }

    @Test
    void addPayment(){
        paymentRepository.save(new Payment("02-04-2021 08:40:30 +124534534",423000.0,"54321","1234"));
        ResponseEntity<?> response = paymentController.addPayment("02-04-2021 08:40:30 +124534534",423000.0,"54321","1234");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void getPaymentById(){
        paymentRepository.save(new Payment("02-04-2021 08:40:30 +124534585678567834",423000.0,"54321","1234"));
        ResponseEntity<?> response = paymentController.getPaymentById("02-04-2021 08:40:30 +124534585678567834");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void deletePaymentById(){
        paymentRepository.save(new Payment("02-04-2021 08:40:30 +1245345856354634563456678567834",423000.0,"54321","1234"));
        ResponseEntity<?> response = paymentController.deletePaymentById("02-04-2021 08:40:30 +1245345856354634563456678567834");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }


}

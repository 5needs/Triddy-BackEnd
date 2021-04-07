package edu.eci.ieti.triddy.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PaymentTest {

    @Test
    void createPayment(){
        Payment payment = new Payment("02-04-2021 08:40:30 +1234",423000.0,"54321","1234");
        assertEquals("02-04-2021 08:40:30 +1234", payment.getIdPayment());
        assertEquals(423000.0, payment.getPrice());
        assertEquals("54321", payment.getIdClient());
        assertEquals("1234", payment.getIdProduct());
    }

    @Test
    void validBasicSetMethods(){
        Payment payment = new Payment("02-04-2021 08:40:30 +1234",423000.0,"54321","1234");
        payment.setIdProduct("12341");
        assertEquals("12341", payment.getIdProduct());
        payment.setIdClient("54321333");
        assertEquals("54321333", payment.getIdClient());
        payment.setPrice(4233423232000.0);
        assertEquals(4233423232000.0, payment.getPrice());
    }

    @Test
    void validToStringMethod(){
        Payment payment = new Payment("02-04-2021 08:40:30 +1234",423000.0,"54321","1234");
        String expected = String.format("Payment[ idPayment='%s', price='%s', idClient='%s', idProduct='%s']", "02-04-2021 08:40:30 +1234", "423000.0", "54321", "1234");
        assertEquals(expected, payment.toString());
    }



}



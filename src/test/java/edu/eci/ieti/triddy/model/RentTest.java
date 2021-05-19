package edu.eci.ieti.triddy.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RentTest {
    @Test
    void CreateRent() {
        Rent rent = new Rent("productid","user@mail.com",new Date(), new Date(), "status1");
        assertEquals(new Date(), rent.getInitialDate());
        assertEquals(new Date(), rent.getFinalDate());
        assertEquals("status1", rent.getStatus());
        assertEquals("productid", rent.getProductId());
        assertEquals("user@mail.com", rent.getUserEmail());
    }

    @Test
    void RentSetMethods() {
        Rent rent = new Rent("productid","user@mail.com",new Date(), new Date(), "status");

        rent.setFinalDate(new Date());
        assertEquals(new Date(), rent.getFinalDate());

        rent.setInitialDate(new Date());
        assertEquals(new Date(), rent.getInitialDate());

        rent.setStatus("status");
        assertEquals("status", rent.getStatus());
    }
}

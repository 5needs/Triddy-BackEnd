package edu.eci.ieti.triddy.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RentTest {
    @Test
    void CreateRent() {
        Rent rent = new Rent("dateInitial", "dateFinal", "status");
        assertEquals("dateInitial", rent.getInitialDate());
        assertEquals("dateFinal", rent.getFinalDate());
        assertEquals("status", rent.getStatus());
        assertEquals("productId", rent.getProductId());
        assertEquals("userId", rent.getUserId());
    }

    @Test
    void RentSetMethods() {
        Rent rent = new Rent("dateInitial1", "dateFinal1", "status1");

        rent.setFinalDate("dateFinal");
        assertEquals("dateFinal", rent.getFinalDate());

        rent.setInitialDate("dateInitial");
        assertEquals("dateInitial", rent.getInitialDate());

        rent.setStatus("status");
        assertEquals("status", rent.getStatus());
    }
}

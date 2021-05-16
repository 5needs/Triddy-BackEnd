package edu.eci.ieti.triddy.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReserveTest {

    @Test
    void createReserve(){
        Reserve reserve = new Reserve("123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z");
        assertEquals("123", reserve.getIdReserve());
        assertEquals("12", reserve.getIdClient());
        assertEquals("789",reserve.getIdProduct());
        assertEquals("2021-04-01T19:52:00Z",reserve.getStartDate());
        assertEquals("2021-05-01T19:52:00Z",reserve.getEndDate());
    }

    @Test
    void validToStringMethod(){
        Reserve reserve = new Reserve("123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z");
        String expected = String.format("Reserve[ idReserve='%s', idClient='%s', idProduct='%s', startDate='%s', endDate='%s']", "123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z");
        assertEquals(expected, reserve.toString());
    }
}

package edu.eci.ieti.triddy.model;

import edu.eci.ieti.triddy.model.Points;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointsTest {

    @Test
    void createReserve(){
        Points points = new Points("123","5","2000","Primer Registro");
        assertEquals("123", points.getIdClient());
        assertEquals("5", points.getLevel());
        assertEquals("2000",points.getDiscount());
        assertEquals("Primer Registro",points.getCategory());
    }

    @Test
    void validToStringMethod(){
        Points points = new Points("1234","3","3000","Referido");
        String expected = String.format("Points[ idClient='%s', discount='%s', level='%s', category='%s']", "1234","3000","3","Referido");
        assertEquals(expected, points.toString());
    }
}


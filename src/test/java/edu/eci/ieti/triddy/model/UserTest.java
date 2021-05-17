package edu.eci.ieti.triddy.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {

    @Test
    void createPayment(){
        University university = new University("Andes");
        assertEquals("Andes", university.getIdUniversity());
        assertEquals(0, university.getDiscount());
        assertTrue(university.getStudents().isEmpty());
    }

    @Test
    void validBasicSetMethods(){
        University university = new University("Javeriana");
        university.setDiscount("Javeriana");
        assertEquals(1000, university.getDiscount());
        university.setStudents("63546345");
        assertTrue(university.getStudents().contains("63546345"));
    }

    @Test
    void validToStringMethod(){
        University university = new University("Sabana");
        String expected = String.format("University[ idUniversity='%s', discount='%s', students='%s']", "Sabana", "0", "[]");
        assertEquals(expected, university.toString());
    }

}

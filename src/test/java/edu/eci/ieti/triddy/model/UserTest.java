package edu.eci.ieti.triddy.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {

    @Test
    void createPayment(){
        Reclaim reclaim = new Reclaim("12","13","14","robo","muy malo todo");
        assertEquals("12", reclaim.getIdReclaim());
        assertEquals("13", reclaim.getIdClient());
        assertEquals("14",reclaim.getIdOferent());
        assertEquals("robo", reclaim.getCategory());
        assertEquals("muy malo todo",reclaim.getComment());
    }

    @Test
    void validToStringMethod(){
        Reclaim reclaim = new Reclaim("121","132","143","robo","muy malo todo");
        String expected = String.format("Reclaim[ idReclaim='%s', idClient='%s', idOferent='%s', category='%s', comment='%s']", "121", "132", "143", "robo","muy malo todo");
        assertEquals(expected, reclaim.toString());
    }
}

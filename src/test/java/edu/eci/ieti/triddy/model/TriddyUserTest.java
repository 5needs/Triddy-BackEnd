package edu.eci.ieti.triddy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TriddyUserTest {
    
    @Test
    void createUser(){
        User user = new User("test@mail.com", "tester");
        assertEquals("tester", user.getName());
    }

    @Test
    void validSetMethods(){
        User user = new User("test@mail.com", "tester");
        user.setEmail("other@mail.com");
        user.setName("other");
        user.setId("AB2");
        assertEquals("other", user.getName());
        assertEquals("other@mail.com", user.getEmail());
        assertEquals("AB2", user.getId());
    }

    @Test
    void validToStringMethod(){
        User user = new User("test@mail.com", "tester");
        String expected = String.format("User [email= '%s', name= '%s']","test@mail.com", "tester");
        assertEquals(expected, user.toString());
    }
}

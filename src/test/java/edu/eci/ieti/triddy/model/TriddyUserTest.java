package edu.eci.ieti.triddy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TriddyUserTest {
    
    @Test
    void createUser(){
        User user = new User("user@test.com", "123ABC", "tester", "test U", "example career", null, null);
        assertEquals("tester", user.getFullname());
        assertEquals("user@test.com", user.getEmail());
        assertEquals("123ABC", user.getPassword());
    }

    @Test
    void validBasicSetMethods(){
        User user = new User("user@mail.com", "123ABC", "tester", "test U", "example career", null, null);

        user.setEmail("other@mail.com");
        assertEquals("other@mail.com", user.getEmail());

        user.setPassword("456DEF");
        assertEquals("456DEF", user.getPassword());

        user.setFullname("other");
        assertEquals("other", user.getFullname());

        user.setUniversity("other U");
        assertEquals("other U", user.getUniversity());

        user.setCareer("other career");
        assertEquals("other career", user.getCareer());
    }

    @Test
    void validOtherSetsUser(){
        User user = new User("user@mail.com", "123ABC", "tester", "test U", "example career", null, null);
        user.setPicture("http://url.com");
        assertEquals("http://url.com", user.getPicture());
        List<String> fav = new ArrayList<String>();
        fav.add("aaaaa");
        fav.add("bbbbb");
        user.setFavorites(fav);
        assertEquals(2, user.getFavorites().size());
    }

    @Test
    void validToStringMethod(){
        User user = new User("user@test.com", "123ABC", "tester", "test U", "example career", null, null);
        String expected = String.format("User[ email='%s', password='%s', fullname='%s', university='%s', career='%s' ]", "user@test.com", "123ABC", "tester", "test U", "example career");
        assertEquals(expected, user.toString());
    }
}

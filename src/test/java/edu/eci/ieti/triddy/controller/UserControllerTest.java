package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.UserRepository;

@SpringBootTest
class UserControllerTest {

    @Autowired
    UserController userController;
    
    @Autowired
    UserRepository userRepository;
    
    @AfterEach
    void deleteUsers(){
        userRepository.deleteAll();
    }
    @Test
    void getUsersTest(){
        assertNotNull(userController.getUsers());
    }

    @Test
    void postUserTest(){
        User u = new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null);
        ResponseEntity<?> response = userController.postUser(u);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void postNotValidUserTest(){
        User u = new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null);
        userController.postUser(u);
        ResponseEntity<?> response = userController.postUser(u);
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }

    @Test
    void getUserTest(){
        User u = new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null);
        userController.postUser(u);
        ResponseEntity<?> response = userController.getUser("test@mail.com");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getNotValidUserTest(){
        ResponseEntity<?> response = userController.getUser("test@mail.com");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    
    @Test
    void delUserTest(){
        User u = new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null);
        userController.postUser(u);
        ResponseEntity<?> response = userController.delUser("test@mail.com");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void delNotValidUserTest(){
        ResponseEntity<?> response = userController.delUser("test@mail.com");
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }
    
    @Test
    void changeFavoritesTest(){
        User u = new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null);
        userController.postUser(u);
        List<String> favorites = new ArrayList<String>();
        favorites.add("aaaa");
        ResponseEntity<?> response = userController.changeFavorites("test@mail.com", favorites);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void changeFavoritesNotValidTest(){
        List<String> favorites = new ArrayList<String>();
        favorites.add("aaaa");
        ResponseEntity<?> response = userController.changeFavorites("test@mail.com", favorites);
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }
}

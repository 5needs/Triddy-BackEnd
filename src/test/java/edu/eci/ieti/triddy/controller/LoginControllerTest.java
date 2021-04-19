package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.UserRepository;
import edu.eci.ieti.triddy.services.UserService;

@SpringBootTest
public class LoginControllerTest {
    
    @Autowired
    LoginController loginController;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
    
    @AfterEach
    void deleteUsers(){
        userRepository.deleteAll();
    }

    @Test
    void loginTest() throws TriddyServiceException{
        User user = new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null);
        userService.createUser(user);

        ResponseEntity<String> response = loginController.login(new User("test@mail.com", "abc123", null, null, null, null, null));
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void loginFailTest() {

        ResponseEntity<String> response = loginController.login(new User("test@mail.com", "abc123", null, null, null, null, null));
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void loginWrongTest() throws TriddyServiceException {

        User user = new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null);
        userService.createUser(user);

        ResponseEntity<String> response = loginController.login(new User("test@mail.com", "123abc", null, null, null, null, null));
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


    @Test
    void loginNullPasswordTest() {

        ResponseEntity<String> response = loginController.login(new User("test@mail.com", null, null, null, null, null, null));
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void loginNullUsernameTest() {

        ResponseEntity<String> response = loginController.login(new User(null,"123abc" , null, null, null, null, null));
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}

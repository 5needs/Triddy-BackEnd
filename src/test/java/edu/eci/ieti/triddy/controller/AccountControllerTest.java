package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.UserRepository;

@SpringBootTest
public class AccountControllerTest {
    
    @Autowired
    AccountController accountController;
    
    @Autowired
    UserRepository userRepository;

    @AfterEach
    void deleteUsers(){
        userRepository.deleteAll();
    }

    @Test
    void changeFullnameTest(){
        userRepository.save(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null));
        User user = new User("test@mail.com", null, "New Name", null, null, null, null);
        ResponseEntity<?> response = accountController.updateFullname(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void notValidChangeFullnameTest(){
        User user = new User("test@mail.com", null, "New Name", null, null, null, null);
        ResponseEntity<?> response = accountController.updateFullname(user);
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }

    @Test
    void changeUniversityTest(){
        userRepository.save(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null));
        User user = new User("test@mail.com", null, null, "Other uni", null, null, null);
        ResponseEntity<?> response = accountController.updateUniversity(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void notValidChangeUniversityTest(){
        User user = new User("test@mail.com", null, null, "Other uni", null, null, null);
        ResponseEntity<?> response = accountController.updateUniversity(user);
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }
    
    @Test
    void changeCareerTest(){
        userRepository.save(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null));
        User user = new User("test@mail.com", null, null, null, "Other career", null, null);
        ResponseEntity<?> response = accountController.updateCareer(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void notValidChangeCareerTest(){
        User user = new User("test@mail.com", null, null, null, "Other career", null, null);
        ResponseEntity<?> response = accountController.updateCareer(user);
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }

    @Test
    void changePictureTest(){
        userRepository.save(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null));
        User user = new User("test@mail.com", null, null, null, null, "http://example.jpg", null);
        ResponseEntity<?> response = accountController.updatePicture(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void notValidChangePictureTest(){
        User user = new User("test@mail.com", null, null, null, null, "http://example.jpg", null);
        ResponseEntity<?> response = accountController.updatePicture(user);
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }
}

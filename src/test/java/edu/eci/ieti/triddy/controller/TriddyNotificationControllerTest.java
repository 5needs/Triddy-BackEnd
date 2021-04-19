package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.eci.ieti.triddy.model.Notification;
import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.UserRepository;

@SpringBootTest
class TriddyNotificationControllerTest {
    
    @Autowired
    NotificationController notificationController;

    @Autowired
    UserRepository userRepository;
    
    @BeforeEach
    void setTestUser(){
        userRepository.save(new User("user@test.com", "tester"));
    }

    @AfterEach
    void delTestUser(){
        userRepository.deleteByEmail("user@test.com");
    }
    
    @Test
    void getNotificationsTest(){
        ResponseEntity<List<Notification>> response = notificationController.getNotifications("user@test.com");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getNotificationsFailTest(){
        ResponseEntity<List<Notification>> response = notificationController.getNotifications("other@test.com");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void postNotificationTest(){
        Notification notification = new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
        ResponseEntity<Notification> response = notificationController.postNotification(notification);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void postNotificationFailTest(){
        Notification notification = new Notification("other@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
        ResponseEntity<Notification> response = notificationController.postNotification(notification);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void deleteNotificationByIdTest(){
        Notification notification = new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
        ResponseEntity<Notification> res = notificationController.postNotification(notification);
        ResponseEntity<String> response = notificationController.deleteNotification(res.getBody().getId());

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void deleteNotificationByIdFailTest(){
        ResponseEntity<String> response = notificationController.deleteNotification("aaaaa1111");

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());   
    }

    @Test
    void deleteNotificationsByUserTest(){
        Notification notification = new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
        notificationController.postNotification(notification);
        ResponseEntity<String> response = notificationController.deleteNotificationsUser(notification.getUser());

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void deleteNotificationsByUserFailTest(){
        Notification notification = new Notification("other@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
        ResponseEntity<String> response = notificationController.deleteNotificationsUser(notification.getUser());

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());   
    }

}

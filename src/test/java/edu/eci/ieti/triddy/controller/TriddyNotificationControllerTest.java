package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.eci.ieti.triddy.model.Notification;
import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.UserRepository;

@SpringBootTest
public class TriddyNotificationControllerTest {
    
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
    void postAndDeleteNotificationsTest(){

        Notification response = notificationController.postNotification(new Notification("user@test.com", "Type1", new Date(), "A content for test controller", "https://www.google.com/"));
        Notification response2 = notificationController.postNotification(new Notification("user@test.com", "Type1", new Date(), "A content for test controller", "https://www.google.com/"));
        assertNotNull(response);
        assertNotNull(response2);
        assertEquals(2, notificationController.getNotifications("user@test.com").size());

        List<String> list = new ArrayList<String>();
        list.add(response.getId());
        list.add(response2.getId());
        notificationController.deleteNotifications(list);
        assertEquals(0, notificationController.getNotifications("user@test.com").size());

    }

    @Test
    void postAndDeleteByUserNotificationsTest(){

        notificationController.postNotification(new Notification("user@test.com", "Type1", new Date(), "A content for test controller", "https://www.google.com/"));
        notificationController.postNotification(new Notification("user@test.com", "Type1", new Date(), "A content for test controller", "https://www.google.com/"));

        assertEquals(2, notificationController.getNotifications("user@test.com").size());
    
        notificationController.deleteNotificationsUser("user@test.com");
        assertEquals(0, notificationController.getNotifications("user@test.com").size());

    }
}

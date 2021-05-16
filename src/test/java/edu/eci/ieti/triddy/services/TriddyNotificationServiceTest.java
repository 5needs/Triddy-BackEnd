package edu.eci.ieti.triddy.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.eci.ieti.triddy.exceptions.NotificationNotFoundException;
import edu.eci.ieti.triddy.exceptions.UserNotFoundException;
import edu.eci.ieti.triddy.model.Notification;
import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.NotificationRepository;
import edu.eci.ieti.triddy.repository.UserRepository;

@SpringBootTest
class TriddyNotificationServiceTest {

    @Autowired
    NotificationService notificationService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NotificationRepository notificationRepository;

    @BeforeEach
    void setTestUser(){
        userRepository.save(new User("user@test.com", "abc123", "Test User", "test U", "test career", null, null));
    }

    @AfterEach
    void delTestUser(){
        userRepository.deleteByEmail("user@test.com");
        notificationRepository.deleteAll();
    }

    @Test
    void getNotificationsFailTest(){
        try {
            notificationService.getNotifications("other@test.com");
        } catch (UserNotFoundException e) {
            assertEquals("Could not find user other@test.com" ,e.getMessage());
        }
    }

    @Test
    void setNotValidNotificationTest(){      
        try {
            Notification notification = new Notification("other@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
            notificationService.setNotification(notification);    
        } catch (UserNotFoundException e) {
            assertEquals("Could not find user other@test.com" ,e.getMessage());
        }
    }

    @Test
    void delByIdNotificationTest(){      
        try {
            Notification notification = new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
            Notification response = notificationService.setNotification(notification);
            notificationService.delNotification(response.getId());
        } catch (NotificationNotFoundException | UserNotFoundException e) {
            fail(e.getMessage());
        }  
    }

    @Test
    void delByIdFailTest(){
        try {
            notificationService.delNotification("aaaa11111");
            fail();
        } catch (NotificationNotFoundException e) {
            assertEquals("Could not find notification with id: aaaa11111" ,e.getMessage());
        }  
    }

    @Test
    void delByUserNotificationTest(){
        try {
            notificationService.setNotification(new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/"));
            notificationService.setNotification(new Notification("user@test.com", "Type2", new Date(), "A content for other test", "https://www.google.com/"));
            assertEquals(2, notificationService.getNotifications("user@test.com").size());
            notificationService.delNotificationsUser("user@test.com");
            assertEquals(0, notificationService.getNotifications("user@test.com").size());
        } catch (UserNotFoundException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void delByUserNotificationFailTest(){
        try {
            notificationService.delNotificationsUser("other@test.com");
            fail();
        } catch (UserNotFoundException e) {
            assertEquals("Could not find user other@test.com" ,e.getMessage());
        }
    }
}

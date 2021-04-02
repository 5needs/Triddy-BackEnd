package edu.eci.ieti.triddy.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.eci.ieti.triddy.model.Notification;
import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.UserRepository;

@SpringBootTest
public class TriddyNotificationServiceTest {

    @Autowired
    NotificationService notificationService;

    @Autowired
    UserRepository userRepository;

    @Test
    void getNotificationsTest(){
        assertNotNull(notificationService.getNotifications());
    }

    @Test
    void setNotValidNotificationTest(){
        int lon = notificationService.getNotifications().size();
        Notification notification = new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
        Notification response = notificationService.setNotification(notification);
        int lon2 = notificationService.getNotifications().size();
        assertNull(response);
        assertEquals(lon, lon2);
    }

    @Test
    void delByIdNotificationTest(){
        User user = userRepository.save(new User("user@test.com", "tester"));

        int lon = notificationService.getNotifications().size();
        Notification notification = new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
        Notification response = notificationService.setNotification(notification);
        int lon2 = notificationService.getNotifications().size();
        assertNotNull(response);
        assertNotEquals(lon, lon2);

        List<String> ids = new ArrayList<String>();
        ids.add(response.getId());
        notificationService.delNotifications(ids);
        assertEquals(lon, notificationService.getNotifications().size());

        userRepository.deleteById(user.getId());
    }

    @Test
    void delByUserNotificationTest(){
        User user = userRepository.save(new User("user@test.com", "tester"));
        int lon = notificationService.getNotifications().size();
        notificationService.setNotification( new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/"));
        notificationService.setNotification( new Notification("user@test.com", "Type2", new Date(), "A content for other test", "https://www.google.com/"));
        int lon2 = notificationService.getNotifications().size();

        assertNotEquals(lon, lon2);
        notificationService.delNotificationsUser(user.getEmail());
        assertEquals(lon, notificationService.getNotifications().size());

        userRepository.delete(user);

    }

    
    
}

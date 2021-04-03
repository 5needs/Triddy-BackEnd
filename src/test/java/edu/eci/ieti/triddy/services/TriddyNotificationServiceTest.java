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

@SpringBootTest
public class TriddyNotificationServiceTest {

    @Autowired
    NotificationService notificationService;

    @Test
    void setNotValidNotificationTest(){
        int lon = notificationService.getNotifications("other@test.com").size();
        Notification notification = new Notification("other@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
        Notification response = notificationService.setNotification(notification);    
        int lon2 = notificationService.getNotifications("other@test.com").size();
        assertNull(response);
        assertEquals(lon, lon2);
    }

    @Test
    void delByIdNotificationTest(){
        int lon = notificationService.getNotifications("user@test.com").size();
        Notification notification = new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
        Notification response = notificationService.setNotification(notification);
        int lon2 = notificationService.getNotifications("user@test.com").size();
        assertNotNull(response);
        assertNotEquals(lon, lon2);

        List<String> ids = new ArrayList<String>();
        ids.add(response.getId());
        notificationService.delNotifications(ids);
        assertEquals(lon, notificationService.getNotifications("user@test.com").size());
    }

    @Test
    void delByUserNotificationTest(){
        int lon = notificationService.getNotifications("user@test.com").size();
        notificationService.setNotification(new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/"));
        notificationService.setNotification(new Notification("user@test.com", "Type2", new Date(), "A content for other test", "https://www.google.com/"));
        int lon2 = notificationService.getNotifications("user@test.com").size();

        assertNotEquals(lon, lon2);
        notificationService.delNotificationsUser("user@test.com");
        assertEquals(lon, notificationService.getNotifications("user@test.com").size());


    }

    
    
}

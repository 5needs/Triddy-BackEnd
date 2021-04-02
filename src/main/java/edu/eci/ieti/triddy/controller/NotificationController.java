package edu.eci.ieti.triddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.triddy.model.Notification;
import edu.eci.ieti.triddy.services.NotificationService;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notification> getNotification(){
        return notificationService.getNotifications();
    }

    @PostMapping
    public Notification postNotification(@RequestBody Notification notif){
        return notificationService.setNotification(notif);
    }

    @DeleteMapping
    public void deleteNotifications(@RequestBody List<String> notifIds){
        notificationService.delNotifications(notifIds);
    }
}

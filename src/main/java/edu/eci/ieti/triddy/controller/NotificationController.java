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
import edu.eci.ieti.triddy.repository.NotificationRepository;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping
    public List<Notification> getNotification(){
        return notificationRepository.findAll();
    }

    @PostMapping
    public Notification postNotification(@RequestBody Notification notif){
        notificationRepository.save(notif);
        return notif;
    }

    @DeleteMapping
    public void deleteNotifications(@RequestBody List<String> notifIds){
        for (String str: notifIds){
            notificationRepository.deleteById(str);
        }
    }
}

package edu.eci.ieti.triddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.triddy.exceptions.NotificationNotFoundException;
import edu.eci.ieti.triddy.exceptions.UserNotFoundException;
import edu.eci.ieti.triddy.model.Notification;
import edu.eci.ieti.triddy.services.NotificationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/users/{email}/notifications")
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable String email){
        try {
            return new ResponseEntity<>(notificationService.getNotifications(email), HttpStatus.OK) ;
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

    @PostMapping("/notifications")
    public ResponseEntity<Notification> postNotification(@RequestBody Notification notif){
        try {
            return new ResponseEntity<>(notificationService.setNotification(notif), HttpStatus.CREATED) ;
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

    @DeleteMapping("/notifications/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable String id){
        try {
            notificationService.delNotification(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotificationNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{email}/notifications")
    public ResponseEntity<String> deleteNotificationsUser(@PathVariable String email){
        try {
            notificationService.delNotificationsUser(email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

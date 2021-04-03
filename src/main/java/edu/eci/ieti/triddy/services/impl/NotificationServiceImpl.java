package edu.eci.ieti.triddy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.triddy.model.Notification;
import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.NotificationRepository;
import edu.eci.ieti.triddy.repository.UserRepository;
import edu.eci.ieti.triddy.services.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Notification> getNotifications(String email) {
        return notificationRepository.findByUser(email);
    }

    @Override
    public Notification setNotification(Notification notification){
        User user = userRepository.findByEmail(notification.getUser());
        if (user != null){
            return notificationRepository.save(notification);
        }else{
            return null;
        }
        
    }

    @Override
    public void delNotifications(List<String> notifIds) {
        for (String str: notifIds){
            notificationRepository.deleteById(str);
        }
    }

    @Override
    public void delNotificationsUser(String user){
        notificationRepository.deleteByUser(user);
    }
    
}

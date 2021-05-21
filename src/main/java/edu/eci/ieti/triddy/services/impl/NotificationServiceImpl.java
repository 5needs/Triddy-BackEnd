package edu.eci.ieti.triddy.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.triddy.exceptions.NotificationNotFoundException;
import edu.eci.ieti.triddy.exceptions.UserNotFoundException;
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
    public List<Notification> getNotifications(String email) throws UserNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null){
            return notificationRepository.findByUser(email);
        }else{
            throw new UserNotFoundException(email);
        }
    }

    @Override
    public Notification setNotification(Notification notification) throws UserNotFoundException{
        User user = userRepository.findByEmail(notification.getUser());
        if (user != null){
            return notificationRepository.save(notification);
        }else{
            throw new UserNotFoundException(notification.getUser());
        }
    }

    @Override
    public void delNotification(String notifId) throws NotificationNotFoundException {
        Optional<Notification> notification = notificationRepository.findById(notifId);
        if (notification.isPresent()){
            notificationRepository.deleteById(notifId);
        }else{
            throw new NotificationNotFoundException(notifId);
        }
        
    }

    @Override
    public void delNotificationsUser(String user) throws UserNotFoundException{
        User user2 = userRepository.findByEmail(user);
        if (user2 != null){
            notificationRepository.deleteByUser(user);
        }else{
            throw new UserNotFoundException(user);
        }
        
    }
    
}

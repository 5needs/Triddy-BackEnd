package edu.eci.ieti.triddy.services;

import java.util.List;

import edu.eci.ieti.triddy.exceptions.NotificationNotFoundException;
import edu.eci.ieti.triddy.exceptions.UserNotFoundException;
import edu.eci.ieti.triddy.model.Notification;
/**
 * @author Ricar8o
 */
public interface NotificationService {

    List<Notification> getNotifications(String email) throws UserNotFoundException;

    Notification setNotification(Notification notification) throws UserNotFoundException;

    void delNotification(String notifId) throws NotificationNotFoundException;

    void delNotificationsUser(String user) throws UserNotFoundException;
    
}

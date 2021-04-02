package edu.eci.ieti.triddy.services;

import java.util.List;

import edu.eci.ieti.triddy.model.Notification;
/**
 * @author Ricar8o
 */
public interface NotificationService {

    List<Notification> getNotifications();

    Notification setNotification(Notification notification);

    void delNotifications(List<String> notifIds);

    void delNotificationsUser(String user);
    
}

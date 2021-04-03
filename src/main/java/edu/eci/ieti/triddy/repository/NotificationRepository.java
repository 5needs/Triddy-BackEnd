package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Notification;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String>{
    
    public List<Notification> findByUser(String email);
    public void deleteByUser(String user);
}

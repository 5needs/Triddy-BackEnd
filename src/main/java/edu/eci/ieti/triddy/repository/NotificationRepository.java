package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String>{
    
}

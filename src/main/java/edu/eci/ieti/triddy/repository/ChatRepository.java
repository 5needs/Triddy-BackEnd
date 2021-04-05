package edu.eci.ieti.triddy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.triddy.model.Chat;

public interface ChatRepository extends MongoRepository<Chat, String> {

    public Optional<Chat> findById(String id);

    public List<Chat> findByUser1OrUser2(String user1, String user2);
    
}
